<%@page import="entidades.Estado"%>
<%@page import="dao.EstadoDAO"%>
<%@page import="entidades.Cidade"%>
<%@page import="java.util.List"%>
<%@page import="dao.CidadeDAO"%>
<%@page import="entidades.Pessoa"%>
<%@page import="dao.PessoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/1x/outline_perm_identity_white_24dp.png"/>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="./styles/cadastro-usuario.css">
        <title>Cadastro de Usuário - iCad</title>
    </head>
    <body id="body-caduser">        
        <a href="paginaInicial.jsp"><img id="voltar" src="img/2x/outline_arrow_back_black_24dp.png"></a>
        <div id="container">
            <h2 id="texto-cadastro">Cadastro de Usuário</h2>
            <form id="form-cadastro" method="post">
                <div id="infos">
                    <label for="id-field">ID</label>
                    <input type="number" class="cad-field" id="id-field">
                    <br>
                    <label for="name-field">Nome</label>
                    <input type="text" class="cad-field" id="name-field" name="name-field" value="">
                    <br>
                    <label for="surname-field">Sobrenome</label>
                    <input type="text" class="cad-field" id="surname-field" name="surename-field" value="">
                    <br>
                    <label for="cpf-field">CPF</label>
                    <input type="text" class="cad-field" id="cpf-field" name="cpf-field" placeholder="Somente números" value="">
                    <br>
                    <label for="email-field">E-mail</label>
                    <input type="email" class="cad-field" id="email-field" name="email-field" placeholder="joao@email.com" value="">
                    <br>
                    <label for="tel-field">Telefone</label>
                    <input type="tel" class="cad-field" id="tel-field" name="tel-field" placeholder="Somente números" value="">
                    <br>
                    <label for="user-field">Usuário</label>
                    <input type="text" class="cad-field" id="user-field" name="user-field" value="">
                    <br>
                    <label for="pass-field">Senha</label>
                    <input type="passoword" class="cad-field" id="pass-field" name="pass-field" value="">
                    <br>
                    <label for="confpass-field">Confirmar Senha</label>
                    <input type="passoword" class="cad-field" id="confpass-field" value="">
                    <br>
                    <label for="permissions">Permissão</label>
                    <select id="permissions" name="permissions">
                        <option>Administrador</option>
                        <option>Usuário</option>
                    </select>
                    <label for="situacao">Situação</label>
                    <select id="situacao" name="situacao">
                        <option value="ativo">Ativo</option>
                        <option value="inativo">Inativo</option>
                        <option value="bloqueado">Bloqueado</option>
                    </select>
                </div>
                
                <%
                    CidadeDAO cidadeDao = new CidadeDAO();
                    List<Cidade> listaCidade;
                    listaCidade = cidadeDao.consultaCidade();
                    
                    EstadoDAO estadoDao = new EstadoDAO();
                    List<Estado> listaEstado;
                    listaEstado = estadoDao.consultaEstado();

                %>
                
                <div id="localizacao">
                    
                            <!-- ESTADO -->
                    <label for="estado">Estado</label>
                    <select id="estado" name="estado">
                        <%for (int i = 0; i < listaEstado.size(); i++){%>
                            <option><%out.println(listaEstado.get(i).getDescricao());%></option>
                        <%}%>
                    </select>
                    
                    
                            <!-- CIDADE -->
                    <label for="cidade">Cidade</label>

                    <select id="cidade" name="cidade">
                        <%for (int i = 0; i < listaCidade.size(); i++){%>
                            <option><%out.println(listaCidade.get(i).getDescricao());%></option>
                        <%}%>
                    </select>
                    
                            <!-- PAIS -->
                    <label for="pais">País</label>
                    <select id="pais" name="pais">
                        <option>Brasil</option>
                        <option>Uruguai</option>
                    </select>
                    
                    
                </div>
                
                <div id="acoes">
                    <input type="submit" value="Salvar" id="button-salvar-cad">
                    <input type="submit" value="Consultar" id="button-consultar-cad">
                    <input type="submit" value="Excluir" id="button-excluir-cad">
                    <input type="reset" value="Limpar" id="button-limpar">
                </div>
            </form>
        </div>
        <script src="js/validaCamposCadastroUsuario.js"></script>
        <script src="js/mudaAtributoPessoa.js"></script>
    </body>
</html>
