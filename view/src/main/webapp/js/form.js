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
                equalTo: "#password"
            },
            name:{
                required: true,
                minlength: 6,
                maxlength: 16
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
            },
            name:{
                required: "Это поле обязательно для заполнения",
                minlength: "Имя должно быть минимум 4 символа",
                maxlength: "Имя должно быть не более 16 символов"
            }
        }
    });
    $("#loginForm").validate({

        rules:{
            login:{
                required: true,
                minlength: 6
            },
            password:{
                required: true,
                minlength: 6,
                maxlength: 35
            }
        },

        messages:{
            login:{
                required: "Это поле обязательно для заполнения",
                minlength: "Логин не может быть менее 6 символов",
                maxlength: "Максимальное число символо - 35"
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
