$(document).ready(function(){

    $("#registerForm").validate({

        rules:{
            email:{
                required: true,
                email: true,
                minlength: 4,
                maxlength: 16
            },
            password:{
                required: true,
                minlength: 6,
                maxlength: 16
            }
        },

        messages:{
            email:{
                required: "Это поле обязательно для заполнения",
                email:"Это не email",
                minlength: "Логин должен быть минимум 4 символа",
                maxlength: "Максимальное число символо - 16"
            },
            password:{
                required: "Это поле обязательно для заполнения",
                minlength: "Пароль должен быть минимум 6 символа",
                maxlength: "Пароль должен быть максимум 16 символов"
            }
        }
    });

    $('a.flipper').click(function(){
        $('.flip').toggleClass('flipped');
    });

});
