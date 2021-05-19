package dao;

import entidades.Pessoa;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
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
    
    
    public boolean inserePessoa(
            String usuario, String senha, String nome, String sobrenome, String cpf, String telefone, String email, String situacao, 
            String permissao, String cidade, String estado, String pais
    ) throws SQLException, NoSuchAlgorithmException {        
        int status = 0;
        Connection con = getConnection();
        String senhaCriptografada = criptoSenha(senha);
        PreparedStatement ps = con.prepareStatement("INSERT INTO pessoa "
                + "(id, usuario, senha, nome, sobrenome, cpf, telefone, email, situacao, permissao, cidade, estado, pais)"
                + " VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, usuario);
        ps.setString(2, senhaCriptografada);
        ps.setString(3, nome);
        ps.setString(4, sobrenome);
        ps.setString(5, cpf);
        ps.setString(6, telefone);
        ps.setString(7, email);
        ps.setString(8, situacao);
        ps.setString(9, permissao);
        ps.setString(10, cidade);
        ps.setString(11, estado);
        ps.setString(12, pais);
        status = ps.executeUpdate();
        return status == 1;
    }
    
    public List<Pessoa> consultaBanco(String cpf) throws SQLException {
        List<Pessoa> listaPessoa = new ArrayList<>();
        
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM pessoa where cpf = ?");
        ps.setString(1, cpf);
        ResultSet resultado = ps.executeQuery();
        while(resultado.next()) {
            Pessoa p = new Pessoa();
            p.setId(resultado.getInt("id"));
            p.setUsuario(resultado.getString("usuario"));
            p.setSenha(resultado.getString("senha"));
            p.setNome(resultado.getString("nome"));
            p.setSobrenome(resultado.getString("sobrenome"));
            p.setCpf(resultado.getString("cpf"));
            p.setTelefone(resultado.getString("telefone"));
            p.setEmail(resultado.getString("email"));
            p.setSituacao(resultado.getString("situacao"));
            p.setPermissao(resultado.getString("permissao"));
            p.setCidade(resultado.getString("cidade"));
            p.setEstado(resultado.getString("estado"));
            p.setPais(resultado.getString("pais"));
            
            listaPessoa.add(p);
        }
        return listaPessoa;
    }
    
    public boolean excluiPessoa(String cpf) throws SQLException {
        int status = 0;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM pessoa WHERE cpf = ?");
        ps.setString(1, cpf);
        status = ps.executeUpdate();
        return status == 1;
    }
    
    public boolean validaLogin(String usuario, String senha) throws SQLException {
        boolean status;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM pessoa WHERE usuario = ? AND senha = ?");
        ps.setString(1, usuario);
        ps.setString(2, senha);
        ResultSet resultado = ps.executeQuery();
        status = resultado.next();
        return status;
    }
    
    public String criptoSenha(String senha) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, m.digest(senha.getBytes()));
        String hashPass = hash.toString(16);
        return hashPass;
    }
}
