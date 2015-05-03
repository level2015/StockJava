<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
    <%--<link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">--%>
    <%--<link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">--%>
</head>

<body>

<!-- vladmaxi top bar -->
<div class="vladmaxi-top">
    <a href="http://vladmaxi.net" target="_blank">Главная Vladmaxi.net</a>
        <span class="right">
        <a href="http://vladmaxi.net/web-developer/css/22-luchshix-formy-vxoda-i-registracii-na-sajte-v-html-css.html">
            <strong>Вернуться назад к статье</strong>
        </a>
        </span>
    <div class="clr"></div>
</div>
<!--/ vladmaxi top bar -->

<div id="login">
    <div class="flip">
        <div class="form-signup">
            <h1>Регистрация</h1>
            <fieldset>
                <p class="login-msg"></p>
                <form>
                    <input type="email" placeholder="Введите Ваш email адрес..." required />
                    <input type="password" placeholder="Ваш сложный пароль..." required />
                    <input type="text" placeholder="Имя пользователя" required />
                    <input type="submit" value="Зарегистрироваться" />
                </form>
                <p>Войти через: <span class="social fb">Facebook</span> <span class="social gp">Google +</span></p>
                <a href="#" class="flipper">Уже зарегистрированы? Войти.</a>
            </fieldset>
        </div>
        <div class="form-login">
            <h1>Авторизация</h1>
            <fieldset>
                <form>
                    <input type="email" placeholder="Логин или Email" required />
                    <input type="password" placeholder="Пароль" required />
                    <input type="submit" value="ВОЙТИ" />
                </form>
                <p>Войти через: <span class="social fb">Facebook</span> <span class="social gp">Google +</span></p>
                <p><a href="#" class="flipper">Нет аккаунта? Регистрация.</a><br>
                    <a href="#">Забыли пароль?</a></p>
            </fieldset>
        </div>
    </div>
</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="js/index.js"></script>

</body>
</html>
