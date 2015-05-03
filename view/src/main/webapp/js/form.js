$(document).ready(function(){

    $("#registerForm").validate({

        rules:{
            email:{
                required: true,
                email: true

            },
            password:{
                required: true,
                minlength: 6,
                maxlength: 16
            },
            confirmPassword:{
                required: true,
                minlength: 6,
                maxlength: 16,
                equalTo: "#password"
            }
        },

        messages:{
            email:{
                required: "Это поле обязательно для заполнения",
                email:"Это не email"
            },
            password:{
                required: "Это поле обязательно для заполнения",
                minlength: "Пароль должен быть минимум 6 символа",
                maxlength: "Пароль должен быть максимум 16 символов"
            },
            confirmPassword:{
                required: "Это поле обязательно для заполнения",
                equalTo:"Не совпадает с паролем"
            }
        }
    });
    $("#loginForm").validate({

        rules:{
            login:{
                required: true,
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
            login:{
                required: "Это поле обязательно для заполнения",
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
