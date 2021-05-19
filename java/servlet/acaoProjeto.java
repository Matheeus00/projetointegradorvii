package servlet;

import dao.ProjetoDAO;
import entidades.Projeto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class acaoProjeto extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet acaoProjeto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet acaoProjeto at " + request.getContextPath() + "</h1>");
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
        
        ProjetoDAO projetoDao = new ProjetoDAO();
        String parametro = request.getParameter("param");
        
        
        ///// CADASTRO DE PROJETOS /////
        if (parametro.equals("cadastroProjeto")) {
            Projeto p = new Projeto();
            
            String titulo = (String) request.getParameter("title-field");
            String descricao = (String) request.getParameter("desc-field");
            
            p.setTitulo(titulo);
            p.setDescricao(descricao);
            
            
            try {
                if (projetoDao.insereProjeto(p.getTitulo(), p.getDescricao())) {
                    RequestDispatcher rd = request.getRequestDispatcher("sucessoInsercaoProjeto.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("cadastroProjeto.jsp");
                    rd.forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(acao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
        
        ///// EXCLUSÃO DE PROJETOS /////
        if (parametro.equals("excluirProjeto")) {
            Projeto p = new Projeto();
            
            String titulo = (String) request.getParameter("title-field");
            p.setTitulo(titulo);
            
            try {  
                if (projetoDao.excluiProjeto(p.getTitulo())) {
                   RequestDispatcher rd = request.getRequestDispatcher("sucessoRemocaoProjeto.jsp");
                   rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("cadastroProjeto.jsp");
                    rd.forward(request, response); 
                }
            } catch (SQLException ex) {
                Logger.getLogger(acao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ///// CONSULTA DE PROJETOS /////
        if (parametro.equals("consultarProjeto")) {
            RequestDispatcher rd = request.getRequestDispatcher("mostraCadastroProjeto.jsp");
            rd.forward(request, response);
        }
        
        ///// MOSTRAS TODOS PROJETOS EM PDF /////  
        if (parametro.equals("visualizarTudo")) {
            RequestDispatcher rd = request.getRequestDispatcher("mostraTudoProjeto.jsp");
            rd.forward(request, response); 
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
