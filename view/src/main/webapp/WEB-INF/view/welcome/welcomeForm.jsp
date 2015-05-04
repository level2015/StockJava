<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.11.2.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <%--<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>--%>
    <script src="/js/form.js"></script>
    <%--<link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">--%>
    <%--<link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">--%>
</head>

<body>


<div id="login">
    <div class="flip">
        <div class="form-signup">
            <h1>Регистрация</h1>
            <fieldset>
                <p class="login-msg"></p>
                <form action="/user/create" method="post" id="registerForm" >
                    <input type="email" name="email" placeholder="Введите Ваш email адрес..." required />
                    <input type="password" id="password" name="password" placeholder="Ваш сложный пароль..." required />
                    <input type="password" name="confirmPassword" placeholder="Подтверждение пароля..." required />
                    <input type="text" name="name" placeholder="Имя пользователя" required />
                    <input type="submit" value="Зарегистрироваться" />
                </form>

                <a href="#" class="flipper">Уже зарегистрированы? Войти.</a>
            </fieldset>
        </div>
        <div class="form-login">
            <h1>Авторизация</h1>
            <fieldset>
                <form id="loginForm">
                    <input type="email" name="login" placeholder="Логин или Email" required />
                    <input type="password" name="password" placeholder="Пароль" required />
                    <input type="submit" value="ВОЙТИ" />
                </form>

                <p><a href="#" class="flipper">Нет аккаунта? Регистрация.</a><br>
                    <a href="#">Забыли пароль?</a></p>
            </fieldset>
        </div>
    </div>
</div>


</body>
</html>
