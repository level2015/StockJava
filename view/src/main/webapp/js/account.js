$(document).ready(function() {


    //setInterval(function () {
    //    $.ajax({
    //        url: 'all',
    //        dataType: 'json',
    //        contentType: "application/json; charset=utf-8",
    //        type: "POST",
    //        success: function (data) {
    //            $('#tbody').html('');
    //            console.log("3333");
    //            for (var i = 0; i < data.length; i++) {
    //                var tr = "<tr id=" + data[i]["id"] + ">";
    //                var td1 = "<td id='userName'>" + data[i]["userName"] + "</td>";
    //                var td2 = "<td id='password'>" + data[i]["password"] + "</td>";
    //                $("#tbody").append(tr + td1 + td2);
    //            }
    //        }
    //    });
    //}, 500);


    $("#save").click(function() {
        var dataUserName = $("#userName").val();
        var dataPassword = $("#password").val();

        var account = {};
        account.userName = dataUserName;
        account.password = dataPassword;

        console.log("9999");
        $.ajax({
            url:"save",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data : JSON.stringify(account),
            success: function(data){
            }
        });
    });




});