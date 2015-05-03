var titleOfChart='Вклад каждого участника в проект, 2015';
var nameOfPositionInChart='Project share';

$.ajax({
    type: "POST",
    url:"/diagram/pieChart/data",
    data: {dateBegin: "24-04-15", dateEnd: "30-04-15"},
    dataType: "json",
    success: function(dataResponse){
        var name = Array();
        var data = Array();
        var dataArrayFinal = Array();
        for(i=0;i<dataResponse.length;i++) {
            name[i] = dataResponse[i].nameOfCurrency;
            data[i] = dataResponse[i].share;
        }

        for(j=0;j<name.length;j++) {
            var temp = new Array(name[j],data[j]);
            dataArrayFinal[j] = temp;
        }
        showPieChart(dataArrayFinal);
    },
    error: function (jqXHR, textStatus, errorThrown){
        alert(textStatus);
    }
});

function showPieChart(dataArray) {
    $(function () {

        // Radialize the colors
        Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
            return {
                radialGradient: {cx: 0.5, cy: 0.3, r: 0.7},
                stops: [
                    [0, color],
                    [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
                ]
            };
        });

        // Build the chart
        $('#container').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: titleOfChart
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        },
                        connectorColor: 'silver'
                    }
                }
            },
            series: [{
                type: 'pie',
                name: nameOfPositionInChart,
                data: dataArray
            }]
        });
    });
}