package dao;

import entidades.Estado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
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
    
        public List<Estado> consultaEstado() throws SQLException {
            List<Estado> listaEstado = new ArrayList<>();
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT descricao FROM estado ORDER BY descricao;");
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()) {
                Estado e = new Estado();
                e.setDescricao(resultado.getString("descricao"));

                listaEstado.add(e);
        }
        return listaEstado; 
    }
}
