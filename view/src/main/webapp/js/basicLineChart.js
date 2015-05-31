$(document).ready(function () {
    var names = [];
    var dataForChart = [];
    var dataResponseStorage;
    var dateFrom=0;
    var dateTo=0;

    //Выбор даты с/по
    $(function () {
        $("#from").datepicker({
            dateFormat: "dd-mm-yy",
            defaultDate: "+1w",
            changeMonth: true,
            numberOfMonths: 3,
            onClose: function (selectedDate) {
                $("#to").datepicker("option", "minDate", selectedDate);
            }
        });
        $("#to").datepicker({
            dateFormat: "dd-mm-yy",
            defaultDate: "+1w",
            changeMonth: true,
            numberOfMonths: 3,
            onClose: function (selectedDate) {
                $("#from").datepicker("option", "maxDate", selectedDate);
            }
        });
    });

    $("#showButtonBCLine").click(function () {
        dateFrom = $("#from").datepicker("getDate");
        dateTo = $("#to").datepicker("getDate");
        if ((dateFrom === null) || (dateTo === null)) {
            alert("Не все даты указаны! Пожалуйста, проверьте еще раз.");
        } else {
            $.ajax({
                type: "POST",
                url: "/diagram/basicLineChart/data",
                data: {dateBegin: dateFrom.getTime(), dateEnd: dateTo.getTime()},
                dataType: "json",
                success: function (dataResponse) {

                    //Сохранение полученных данных от сервера
                    dataResponseStorage = dataResponse;
                    //Вызываем функцию отрисовки чекбоксов
                    getCheckBoxes(dataResponse);
                    //Вызов отрисовки графика
                    showChartWithFullData(dataResponseStorage);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(textStatus);
                }
            });
        }
    });

    function getCheckBoxes(dataResponse) {
        names = [];
        $('#checkBox').html(" ");
        for (var i = 0; i < dataResponse.length; i++) {
            names.push(dataResponse[i].name);
            $('#checkBox').append("<input class='generated' type='checkbox' id='" + names[i] + "' checked='checked'/>" + names[i]);
        }
    };

    function showChartWithFullData(dataResponse) {
        dataForChart = [];
        for (var i = 0; i < dataResponse[0].data.length; i++) {
            if (i==0) {dataForChart[i] = 0;} else {dataForChart[i]=dataForChart[(i-1)]};
            for (var j = 0; j < dataResponse.length; j++) {
                dataForChart[i] += dataResponse[j].data[i];
            }
        }
        showBasicLineChart(dataForChart);
    };

    $(document).on("click", ".generated", function () {
        var nameOfCheckBox = $(this).attr("id");
        for (var i = 0; i < dataResponseStorage.length; i++) {
            if (dataResponseStorage[i].name == nameOfCheckBox) {
                if ($(this).is(':checked')) {
                    for (var j = 0; j < dataResponseStorage[i].data.length; j++) {
                        dataForChart[j] += sumArray(dataResponseStorage, i, j);
                    }
                } else {
                    for (var j = 0; j < dataResponseStorage[i].data.length; j++) {
                        dataForChart[j] -= sumArray(dataResponseStorage, i, j);
                    }
                }
                showBasicLineChart(dataForChart);
            }
        }
    });

    function sumArray (dataResponseStorage, i, j){
        var sum=0;
        for (var k=0; k<=j; k++){
            sum+=dataResponseStorage[i].data[k];
        }
        return sum;
    }

    function showBasicLineChart(dataResponse) {

        $(function () {
            $('#container').highcharts({
                chart: {
                    zoomType: 'x'
                },
                title: {
                    text: dateFrom.getDate() + '/' + dateFrom.getMonth() +'/' + dateFrom.getFullYear() + ' - '
                    + dateTo.getDate() + '/' + dateTo.getMonth() +'/' + dateTo.getFullYear()
                },
                subtitle: {
                    text: document.ontouchstart === undefined ?
                        'Click and drag in the plot area to zoom in' :
                        'Pinch the chart to zoom in'
                },
                xAxis: {
                    type: 'datetime',
                    minRange: 14 * 24 * 3600000 // fourteen days
                },
                yAxis: {
                    title: {
                        text: 'Financial balance'
                    }
                },
                legend: {
                    enabled: false
                },
                plotOptions: {
                    area: {
                        fillColor: {
                            linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                            stops: [
                                [0, Highcharts.getOptions().colors[0]],
                                [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                            ]
                        },
                        marker: {
                            radius: 2
                        },
                        lineWidth: 1,
                        states: {
                            hover: {
                                lineWidth: 1
                            }
                        },
                        threshold: null
                    }
                },

                series: [{
                    type: 'area',
                    name: 'Balance',
                    pointInterval: 24 * 3600 * 1000,
                    pointStart: Date.UTC(dateFrom.getFullYear(), dateFrom.getMonth(), dateFrom.getDate()),
                    data: dataResponse
                }]
            });
        });
    }
});


