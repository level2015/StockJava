$(document).ready(function () {
    //Выбор даты с/по
    $(function () {
        $("#from").datepicker({
            defaultDate: "+1w",
            changeMonth: true,
            numberOfMonths: 3,
            onClose: function (selectedDate) {
                $("#to").datepicker("option", "minDate", selectedDate);
            }
        });
        $("#to").datepicker({
            defaultDate: "+1w",
            changeMonth: true,
            numberOfMonths: 3,
            onClose: function (selectedDate) {
                $("#from").datepicker("option", "maxDate", selectedDate);
            }
        });
    });
//Действие по нажатию кнопки "показать"
    $("#showButtonBC").click(function () {
        var dateFrom = $("#from").datepicker("getDate");
        var dateTo = $("#to").datepicker("getDate");
        if ((dateFrom === null) || (dateTo === null)) {
            alert("Не все даты указаны! Пожалуйста, проверьте еще раз.");
        } else {

//Запрос к серверу на получение данных по клику по кнопке
            $.ajax({
                type: "POST",
                url: "/diagram/basicBarChart/data",
                data: {dateBegin: dateFrom.getTime(), dateEnd: dateTo.getTime()},
                dataType: "json",
                success: function (dataResponse) {
                    //Вызов отрисовки графика
                    showBarChart(dataResponse);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(textStatus);
                }
            });
        }
//Функция отрисовки графика по полученным данным
        function showBarChart(dataResponse) {
            $('#container').highcharts({
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'Сумма профитов по годам'
                },
                xAxis: {
                    categories: ['2009', '2010', 'Pears', 'Grapes', 'Bananas']
                },
                credits: {
                    enabled: false
                },
                series: dataResponse
            });
        }
    });
});