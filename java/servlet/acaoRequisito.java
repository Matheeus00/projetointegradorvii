package servlet;

import dao.RequisitoDAO;
import entidades.Requisito;
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

public class acaoRequisito extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet acaoRequisito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet acaoRequisito at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequisitoDAO requisitoDao = new RequisitoDAO();
        String parametro = request.getParameter("param");
        
        
        ///// CADASTRO DE REQUISITOS /////
        if (parametro.equals("cadastroRequisito")) {
            Requisito r = new Requisito();
            
            String codigo = (String) request.getParameter("cod-field");
            String complexidade = (String) request.getParameter("comp-field");
            String prioridade = (String) request.getParameter("pri-radio");
            String tipo = (String) request.getParameter("tipo-radio");
            String titulo = (String) request.getParameter("title-field");
            String descricao = (String) request.getParameter("desc-field");
            
            r.setCodigo(Integer.parseInt(codigo));
            r.setComplexidade(Integer.parseInt(complexidade));
            r.setPrioridade(prioridade);
            r.setTipo(Integer.parseInt(tipo));
            r.setTitulo(titulo);
            r.setDescricao(descricao);
            
            try {
                if (requisitoDao.insereRequisito(r.getCodigo(), r.getComplexidade(), r.getPrioridade(), r.getTipo(), r.getTitulo(), r.getDescricao())) {
                    RequestDispatcher rd = request.getRequestDispatcher("sucessoInsercaoRequisito.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("cadastroRequisitos.jsp");
                    rd.forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(acaoRequisito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ///// EXCLUSÃO DE REQUISITOS /////
        if (parametro.equals("excluirRequisito")) {
            Requisito r = new Requisito();
            String codigo = (String) request.getParameter("cod-field");
            r.setCodigo(Integer.parseInt(codigo));
            
            
            try {
                if (requisitoDao.excluiRequisito(r.getCodigo())){
                    RequestDispatcher rd = request.getRequestDispatcher("sucessoRemocaoRequisito.jsp");
                    rd.forward(request, response); 
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("cadastroRequisitos.jsp");
                    rd.forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(acaoRequisito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ///// MOSTRAS TODOS REQUISITOS EM PDF /////     
        if (parametro.equals("visualizarTudo")) {
            RequestDispatcher rd = request.getRequestDispatcher("mostraTudoRequisito.jsp");
            rd.forward(request, response); 
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
