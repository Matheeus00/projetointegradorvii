package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DadosDAO {
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
    
    public int consultaPessoasCadastradas() throws SQLException {
	int numero = 0;
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM pessoa;");
	ResultSet resultado = ps.executeQuery();
	while(resultado.next()) {
		numero = resultado.getInt("count");
	}
	return numero; 
    }
    
    public int consultaProjetosCadastrados() throws SQLException {
	int numero = 0;
	Connection con = getConnection();
	PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM projeto;");
	ResultSet resultado = ps.executeQuery();
	while(resultado.next()) {
		numero = resultado.getInt("count");
	}
	return numero; 
    }
    
    public int consultaReqFuncionais() throws SQLException {
        int numero = 0;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM requisito WHERE fk_tipo_requisito = 1;");
        ResultSet resultado = ps.executeQuery();
        while(resultado.next()) {
                numero = resultado.getInt("count");
        }
        return numero; 
    }
    
    public int consultaReqNaoFuncionais() throws SQLException {
        int numero = 0;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM requisito WHERE fk_tipo_requisito = 4;");
        ResultSet resultado = ps.executeQuery();
        while(resultado.next()) {
                numero = resultado.getInt("count");
        }
        return numero; 
    }
}
