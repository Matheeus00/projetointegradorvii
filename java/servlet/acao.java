package servlet;

import dao.PessoaDAO;
import entidades.Pessoa;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class acao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet acao</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet acao at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PessoaDAO pessoaDao = new PessoaDAO();
        
        String parametro = request.getParameter("param");
        
        ///// LOGIN /////
        if(parametro.equals("login")) {
           Usuario u = new Usuario();
           
           String usuario = (String) request.getParameter("user-field");
           String senha = (String) request.getParameter("pass-field");
            
           u.setUsuario(usuario);
           u.setSenha(senha);

           try {
               if(pessoaDao.validaLogin(u.getUsuario(), u.getSenha())){
                    RequestDispatcher rd = request.getRequestDispatcher("paginaInicial.jsp");
                    rd.forward(request, response);
               } else {
                   RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                   rd.forward(request, response);
               }
           } catch (SQLException ex) {
                Logger.getLogger(acao.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        ///// CADASTRO DE PESSOA /////
        if(parametro.equals("cadastroPessoa")) {
            Pessoa p = new Pessoa();
            
            String nome = (String) request.getParameter("name-field");
            String sobrenome = (String) request.getParameter("surename-field");
            String cpf = (String) request.getParameter("cpf-field");
            String email = (String) request.getParameter("email-field");
            String tel = (String) request.getParameter("tel-field");
            String usuario = (String) request.getParameter("user-field");
            String senha = (String) request.getParameter("pass-field");
            String permissao = (String) request.getParameter("permissions");
            String situacao = (String) request.getParameter("situacao");
            String cidade = (String) request.getParameter("cidade");
            String estado = (String) request.getParameter("estado");
            String pais = (String) request.getParameter("pais");
            
            p.setNome(nome);
            p.setSobrenome(sobrenome);
            p.setCpf(cpf);
            p.setEmail(email);
            p.setTelefone(tel);
            p.setUsuario(usuario);
            p.setSenha(senha);
            p.setPermissao(permissao);
            p.setSituacao(situacao);
            p.setCidade(cidade);
            p.setEstado(estado);
            p.setPais(pais);
            
            
            try {
                if(pessoaDao.inserePessoa(
                        p.getUsuario(), p.getSenha(), p.getNome(), p.getSobrenome(), p.getCpf(), p.getTelefone(), 
                        p.getEmail(), p.getSituacao(), p.getPermissao(), p.getCidade(), p.getEstado(), p.getPais()
                )) {
                    RequestDispatcher rd = request.getRequestDispatcher("sucessoInsercaoPessoa.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("cadastroUsuario.jsp");
                    rd.forward(request, response);
                }
            } catch (SQLException | NoSuchAlgorithmException ex) {
                Logger.getLogger(acao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ///// EXCLUIR PESSOA /////
        if (parametro.equals("excluirPessoa")) {
            Pessoa p = new Pessoa();
            
            String cpf = (String) request.getParameter("cpf-field");
            p.setCpf(cpf);
            
            try {
                if (pessoaDao.excluiPessoa(p.getCpf())) {
                   RequestDispatcher rd = request.getRequestDispatcher("sucessoRemocaoPessoa.jsp");
                   rd.forward(request, response); 
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("cadastroUsuario.jsp");
                    rd.forward(request, response);  
                }
            } catch (SQLException ex) {
                Logger.getLogger(acao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ///// CONSULTA PESSOA /////
        if (parametro.equals("consultarPessoa")){
            RequestDispatcher rd = request.getRequestDispatcher("mostraCadastroUsuario.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
