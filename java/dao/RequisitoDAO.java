package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequisitoDAO {
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
    
    public boolean insereRequisito(
            int codigo, int complexidade, String prioridade, 
            int tipo, String titulo, String descricao
    ) throws SQLException {
        int status = 0;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO requisito "
                + "(id, titulo, descricao, codigo, complexidade, prioridade, fk_tipo_requisito)"
                + " VALUES (default, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, titulo);
        ps.setString(2, descricao);
        ps.setInt(3, codigo);
        ps.setInt(4, complexidade);
        ps.setString(5, prioridade);
        ps.setInt(6, tipo);
        status = ps.executeUpdate();
        return status == 1;
    }
    
    
    public boolean excluiRequisito(int codigo) throws SQLException {
        int status = 0;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM requisito where codigo = ?");
        ps.setInt(1, codigo);
        status = ps.executeUpdate();
        return status == 1;
    } 
}
