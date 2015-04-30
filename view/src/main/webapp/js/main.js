$(document).ready(function(){


    ShowResult();

    console.log("222");
    function ShowResult() {
        console.log("4444");
        //setInterval(function () {
        $.ajax({
            url: 'allProducts',
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            type: "POST",
            success: function (data) {
                $('#tbody').html('');
                //charts = data;
                console.log("3333");
                for (var i = 0; i < data.length; i++) {
                    var tr = "<tr id=" + data[i]["article"] + ">";
                    var td1 = "<td id='article'>" + data[i]["article"] + "</td>";
                    var td2 = "<td id='description'>" + data[i]["description"] + "</td>";
                    var td3 = "<td id='mainPrice'>" + data[i]["mainPrice"] + "</td>";
                    var td4 = "<td id='categoryId'>" + data[i]["categoryId"] + "</td>";
                    $("#tbody").append(tr + td1 + td2 + td3 + td4);
                }
            }
        });
        //}, 500);
    };
    $("#nextPage").click(function()  {

        ShowResult();
    });



    console.log("222");
    $("#deleteCateg").click(function() {
        var dataCategory = $("select option:selected").val();
        $.ajax({
            url: "/product/deleteCategory?nameCategory=" + dataCategory,
            contentType: "application/json; charset=utf-8",
            //data : JSON.stringify(dataCategory),
            success: function (data) {

            }
        });
    });

    $("#save").click(function() {


        var dataArticle = $("#article").val();
        var dataDescription = $("#description").val();
        var dataMainPrice  = $("#mainPrice").val();
        var dataCategoryId  = $("#categoryId").val();

        var product = {};
        product.article = dataArticle;
        product.description = dataDescription;
        product.mainPrice = dataMainPrice;
        product.categoryId = dataCategoryId;

        console.log("9999");
        $.ajax({
            url:"save",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data : JSON.stringify(product),
            success: function(data){

            }
        });

    });


        //$.getJSON("demo_ajax_json.js", function(result){
        //    $.each(result, function(i, field){
        //        $("div").append(field + " ");
        //    });
        //});
});






