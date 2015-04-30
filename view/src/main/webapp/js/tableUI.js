$(document).ready(function() {






    $("#nextStep1").click(function() {
        //$("#step-two").show();
        $("#step-two").show( "explode", {pieces: 16}, 1500 );
        //$( "#step-two" ).effect( "shake", {
        //    times: 2,
        //    distance: 100
        //}, 3000);
    });

    $("#previous").click(function() {
        //$("#step-two").hide();

        $("#step-two").hide( "explode", {pieces: 16 }, 1500 );
        //$( "#step-two" ).effect({
        //    effect: "explode",
        //    easing: "easeInExpo",
        //    pieces: 8,
        //    duration: 1500
        //});
    });

    //$("#nextStep2").click(function() {
    //
    //    var user = {};
    //    user.name = $("#name").val();
    //    user.lastName = $("#lastName").val();
    //    user.pid = $("#pid").val();
    //    $("#formStep3").show();
    //    console.log("22222");
    //    $.ajax({
    //      url:"/user/save",
    //      type: "POST",
    //      contentType:"application/json; charset=utf-8",
    //      dataType: 'json',
    //      data: JSON.stringify(user),
    //      success: function(data){
    //          console.log(data.name);
    //          console.log(data.lastName);
    //          console.log(data.pid);
    //            $('#form3').html('');
    //            console.log("3333");
    //            //for (var i = 0; i < data.length; i++) {
    //               // var tr = "<tr id=" + data[i]["name"] +
    //                var tr = "<tr id = 1>";
    //                var td1 = "<td id='nameU'>" + data.name + "</td>";
    //                var td2 = "<td id='lastNameU'>" + data.lastName + "</td>";
    //                var td3 = "<td id='pidU'>" + data.pid + "</td>";
    //                $("#form3").append(tr + td1 + td2 + td3);
    //           // }
    //
    //      }
    //    });
    //
    //});

    $("#nextStep2").click(function(){

        $.ajax({
            url:"/user/save",
            type: "POST",
            data: $("#form").serialize(),
            success: function(data){
                $("#form3").html('');
                var tr = "<tr id=data.name>";
                var td1 = "<td id='name-user'>" + data.name + "</td>";
                var td2 = "<td id='lastName-user'>" + data.lastName + "</td>";
                var td3 = "<td id='pid-user'>" + data.pid + "</td>";
                $("#form3").append(tr + td1 + td2 + td3);
                $("#form").hide();
                //$("#formStep3").show();

                $("#formStep3").show();
                //$("#formStep3").show( "puff", {percent:100}, 2000 );

            }
        })
    });


});