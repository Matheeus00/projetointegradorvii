<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <title>Login - iCad</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/2x/outline_info_white_24dp.png"/>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="./styles/login.css">
    <body id="body-login">
        <div id="container">
            <img id="logo-login" src="img/logo.PNG" alt="Logo iCad">
            <br>
            <p id="boasvindas">Bem-vindo(a) ao iCad</p>
            <form id="form-login" method="post">
                <label for="user-field">Usuário</label>
                <br>
                <input type="text" class="login-field" id="user-field" name="user-field" placeholder="joao.silva" required>
                <br>
                <label for="pass-field">Senha</label>
                <br>
                <input type="password"  class="login-field" id="pass-field" name="pass-field" required>
                <br>
                <div id="acoes">
                    <input type="submit" value="Login" id="button-login">
                </div>
            </form>
        </div>
        <script src="js/validaCamposLogin.js"></script>
    </body>
</html>
