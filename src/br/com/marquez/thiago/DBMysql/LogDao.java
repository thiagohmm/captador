package br.com.marquez.thiago.DBMysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.marquez.thiago.model.Cliente;
import br.com.marquez.thiago.model.Conversa;
import br.com.marquez.thiago.model.Login;

public class LogDao {

	
	
private Connection connection;
	
	public LogDao(){
		this.connection = new ConnectionFactory().getConnection();
		
	}

	
public boolean existeUsuario(Login usuario) {
		
		if(usuario == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from tbllogin where login = ? and senha = ?");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();

			boolean encontrado = rs.next();
			rs.close();
			stmt.close();

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}




}





public List<Login> ListaLogin(){
	try{
		List<Login> loglistobj = new ArrayList<Login>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tbllogin");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			Login loginobj = new Login();
			
			
			loginobj.setIdLogin(rs.getLong("idLogin"));
			loginobj.setLogin(rs.getString("login"));
			loginobj.setSenha(rs.getString("senha"));
				
			
			loglistobj.add(loginobj);
		}
		rs.close();
		stmt.close();
		return loglistobj;
		
	}catch (SQLException e){
		throw new RuntimeException(e);
	}
}



public void adicionaLogin(Login logobj){
	String sql = "INSERT INTO tbllogin(login,senha)" +
                    " VALUES(?,?)";
	
	try{
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		
		
		stmt.setString(1, logobj.getLogin());
		stmt.setString(2, logobj.getSenha());
        stmt.execute();
		stmt.close();
                    
		
	}catch (SQLException e){
		throw new RuntimeException(e);
	}
	
}

	public void deletaLogin(Login logobj) {

	

	String sql = "delete from tbllogin where idLogin = ?";
	PreparedStatement stmt;
	
	try {
		stmt = connection.prepareStatement(sql);
		stmt.setLong(1, logobj.getIdLogin());
		stmt.execute();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}

}

	
public boolean verificaUsuario(Login usuario) {
		
		if(usuario == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from tbllogin where login = ?");
			stmt.setString(1, usuario.getLogin());
			ResultSet rs = stmt.executeQuery();

			boolean encontrado = rs.next();
			rs.close();
			stmt.close();

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	
}	
	
	
	
	
}	

