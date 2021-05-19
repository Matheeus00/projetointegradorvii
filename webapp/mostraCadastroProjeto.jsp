<%@page import="java.util.List"%>
<%@page import="entidades.Projeto"%>
<%@page import="entidades.Projeto"%>
<%@page import="dao.ProjetoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="./styles/mostra-projeto.css">
        <title>Mostra Cadastro Projeto</title>
    </head>
    <body id="body-mostraproj">
        <%
        ProjetoDAO projetoDao = new ProjetoDAO();

        List<Projeto> listaProjeto;
        listaProjeto = projetoDao.consultaProjeto(request.getParameter("title-field"));
        %>
        <h1 id="title">Cadastro do Projeto</h1>
        <div>
            <div id="container">
                <table cellspacing="0">
                    <tr>
                        <th>ID</th>
                        <th>Titulo</th>
                        <th id="tdesc">Descrição</th>
                    </tr>
                    <tr>
                    <% 
                    for (int i = 0; i < listaProjeto.size(); i++) { 
                    %>
                        <td><%= listaProjeto.get(i).getId() %></td>
                        <td><%= listaProjeto.get(i).getTitulo() %></td>
                        <td id="ddesc"><%= listaProjeto.get(i).getDescricao() %></td>
                    <%}%>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
