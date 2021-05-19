package dao;

import entidades.Projeto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/iCad";
    String user = "postgres";
    String password = "postgres";
    
    public Connection getConnection(){  
        try {  
            Class.forName("org.postgresql.Driver"); 
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }  
        return conn;
    }
    
    public boolean insereProjeto(String titulo, String descricao) throws SQLException {
        int status = 0;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO projeto "
                + "(id, titulo, descricao) VALUES (default, ?, ?)");
        ps.setString(1, titulo);
        ps.setString(2, descricao);
        status = ps.executeUpdate();
        return status == 1;
    }
    
        
    public List<Projeto> consultaProjeto(String titulo) throws SQLException {
        List<Projeto> listaProjeto = new ArrayList<>();
        
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM projeto WHERE titulo = ?");
        ps.setString(1, titulo);
        ResultSet resultado = ps.executeQuery();
        while(resultado.next()) {
            Projeto proj = new Projeto();
            proj.setId(resultado.getInt("id"));
            proj.setTitulo(resultado.getString("titulo"));
            proj.setDescricao(resultado.getString("descricao"));
            
            listaProjeto.add(proj);
        }
        return listaProjeto;
    }
    
    
    public boolean excluiProjeto(String titulo) throws SQLException {
        int status = 0;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM projeto WHERE titulo = ?");
        ps.setString(1, titulo);
        status = ps.executeUpdate();
        return status == 1;
    }
}
