<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/1x/outline_list_alt_white_24dp.png"/>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="./styles/cadastro-projeto.css">
        <title>Cadastro de Projeto - iCad</title>
    </head>
    <body id="body-cadproj">
        <a href="paginaInicial.jsp"><img id="voltar" src="img/2x/outline_arrow_back_black_24dp.png"></a>
        <div id="container">
            <h2 id="texto-cadastro">Cadastro de Projeto</h2>
            <form id="form-projeto" method="post">
                <label for="id-field">ID</label>
                <input type="number" class="cad-field" id="id-field">
                <br>
                <label for="title-field">Título</label>
                <br>
                <input type="text" class="title-field" id="title-field" name="title-field">
                <br>
                <label for="desc-field">Descrição</label>
                <br>
                <textarea class="desc-field" id="desc-field" name="desc-field" rows="5" cols="30"></textarea>
                <br>
                <div id="acoes">
                    <input type="submit" value="Salvar" id="button-salvar-cad">
                    <input type="submit" value="Consultar" id="button-consultar-cad">
                    <input type="submit" value="Relatório" id="button-relatorio-cad">
                    <input type="submit" value="Excluir" id="button-excluir-cad">
                    <input type="reset" value="Limpar" id="button-limpar">
                </div>
            </form>
        </div>
        <script src="js/validaCamposProjeto.js"></script>
        <script src="js/mudaAtributoProjeto.js"></script>
    </body>
</html>
