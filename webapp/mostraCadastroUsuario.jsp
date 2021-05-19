<%@page import="dao.PessoaDAO"%>
<%@page import="java.util.List"%>
<%@page import="servlet.acao"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="entidades.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="./styles/mostra-usuario.css">
        <title>Mostra Cadastro Usuário</title>
    </head>
    <body id="body-mostrauser">
        <%
        PessoaDAO pessoaDao = new PessoaDAO();

        List<Pessoa> listaPessoa;
        listaPessoa = pessoaDao.consultaBanco(request.getParameter("cpf-field"));
        %>
        <h1 id="title">Cadastro do Usuário</h1>
        <div>
            <div id="container">
                <table cellspacing="0">
                    <tr>
                        <th>ID</th>
                        <th>Usuário</th>
                        <th>Nome</th>
                        <th>Sobrenome</th>
                        <th>CPF</th>
                        <th>Telefone</th>
                        <th>E-mail</th>
                        <th>Situação</th>
                        <th>Permissão</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>Pais</th>
                    </tr>
                    <tr>
                    <% 
                    for (int i = 0; i < listaPessoa.size(); i++) { 
                    %>
                        <td><%= listaPessoa.get(i).getId() %></td>
                        <td><%= listaPessoa.get(i).getUsuario()%></td>
                        <td><%= listaPessoa.get(i).getNome()%></td>
                        <td><%= listaPessoa.get(i).getSobrenome()%></td>
                        <td><%= listaPessoa.get(i).getCpf()%></td>
                        <td><%= listaPessoa.get(i).getTelefone()%></td>
                        <td><%= listaPessoa.get(i).getEmail()%></td>
                        <td><%= listaPessoa.get(i).getSituacao()%></td>
                        <td><%= listaPessoa.get(i).getPermissao()%></td>
                        <td><%= listaPessoa.get(i).getCidade()%></td>
                        <td><%= listaPessoa.get(i).getEstado()%></td>
                        <td><%= listaPessoa.get(i).getPais()%></td>
                    <%}%>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
