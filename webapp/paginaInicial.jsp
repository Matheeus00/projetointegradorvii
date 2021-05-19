<%@page import="dao.DadosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link rel="shortcut icon" href="img/1x/outline_info_white_24dp.png"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="./styles/paginainicial.css">
        <title>Página Inicial - iCad</title>
    </head>
    <body>
        <div id="navbar">
            <a id="img-logo"><img id="logo-login" src="img/logoInicial.png" alt="Logo iCad"></a>
            <a id="sair">Sair</a>
        </div> 
        <div id="container">
            
            <div id="pessoas" class="div-func">
                <img class="body-img" src="img/2x/outline_account_circle_black_24dp.png">
                <br>
                <%
                    DadosDAO dadosDao = new DadosDAO();
                %>
                <p class="quant"><%= dadosDao.consultaPessoasCadastradas()%></p>
                <p class="titulo">Pessoas<br>Cadastradas</p>
                <br>
                <div class="link">
                    <a href="cadastroUsuario.jsp">+ Adicionar</a>
                </div>
            </div>
            
            <div id="projetos" class="div-func">
                <img class="body-img" src="img/2x/outline_article_black_24dp.png">
                <br>
                <p class="quant"><%= dadosDao.consultaProjetosCadastrados()%></p>               
                <p class="titulo">Projetos<br>Cadastrados</p>
                <br>
                <div class="link">
                    <a href="cadastroProjeto.jsp">+ Adicionar</a>
                </div>
            </div>
            
            <div id="req-func" class="div-func">
                <img class="body-img" src="img/2x/outline_list_alt_black_24dp.png">
                <br>
                <p class="quant"><%= dadosDao.consultaReqFuncionais()%></p>
                <p class="titulo">Requisitos<br>Funcionais<br>Cadastrados</p>
                <br>
                <div class="link">
                    <a href="cadastroRequisitos.jsp">+ Adicionar</a>
                </div>
            </div>
            
            <div id="req-nao-func" class="div-func">
                <img class="body-img" src="img/2x/outline_clear_all_black_24dp.png">
                <br>
                <p class="quant"><%= dadosDao.consultaReqNaoFuncionais()%></p>
                <p class="titulo">Requisitos<br>Não-Funcionais<br>Cadastrados</p>
                <br>
                <div class="link">
                    <a href="cadastroRequisitos.jsp">+ Adicionar</a>
                </div>
            </div>
        </div>
                <script src="js/sairPaginaInicial.js"></script>
    </body>
</html>
