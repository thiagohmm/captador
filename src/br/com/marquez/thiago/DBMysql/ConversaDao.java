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






public class ConversaDao {
private Connection connection;
	
	public ConversaDao(){
		this.connection = new ConnectionFactory().getConnection();
		
	}

    
    
    
    
    
    
 

	


 public void adicionaConversa(Conversa convobj){
		String sql = "INSERT INTO tblconversa(conversa_data,conversa_assunto,conversa_texto,fkidCliente)" +
                        " VALUES(?,?,?,?)";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			stmt.setDate(1 ,new Date (convobj.getConversaData().getTimeInMillis()));
			stmt.setString(2, convobj.getConversaAssunto());
			stmt.setString(3, convobj.getConversaTexto());
            stmt.setLong(4, convobj.getfKCliente());
                       
                        
                        
                        
                        
                        
			//stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
                        
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}


 
 
 
 public List<Conversa> ListaConversaPorfk(Long fKCliente){
		try{
			List<Conversa> prosa = new ArrayList<Conversa>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblconversa where fkidCliente = ?");
			stmt.setLong(1, fKCliente);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Conversa convobj = new Conversa();
				
				
				convobj.setIdConversa(rs.getLong("idConversa"));
				convobj.setConversaAssunto(rs.getString("conversa_assunto"));
				convobj.setConversaTexto(rs.getString("conversa_texto"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("conversa_data"));
				convobj.setConversaData(data);
				convobj.setfKCliente(rs.getLong("fkidCliente"));              
				
				
				
				prosa.add(convobj);
			}
			rs.close();
			stmt.close();
			return prosa;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
 
 
 
 
 
 public void remove(Long id) {

		

		String sql = "delete from tblconversa where idconversa = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
 
 
 public List<Conversa> listaConversaPorID(Long id){
		try{
			List<Conversa> prosa = new ArrayList<Conversa>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblconversa where idConversa = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Conversa convobj = new Conversa();
				
				
				convobj.setIdConversa(rs.getLong("idConversa"));
				convobj.setConversaAssunto(rs.getString("conversa_assunto"));
				convobj.setConversaTexto(rs.getString("conversa_texto"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("conversa_data"));
			   convobj.setConversaData(data);
               convobj.setfKCliente(rs.getLong("fkidCliente"));               
				
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataNascimento"));
//				contato.setDataNascimento(data);
//				
				
				
				prosa.add(convobj);
			}
			rs.close();
			stmt.close();
			return prosa;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
 
 
 public void alteraConversa(Conversa convobj){
	 
		String sql = "UPDATE tblconversa set conversa_data=?,"
				+ "conversa_assunto=?,conversa_texto=?,fkidCliente=? where idConversa=?";
                  
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			stmt.setDate(1, new Date (convobj.getConversaData().getTimeInMillis()));
			stmt.setString(2, convobj.getConversaAssunto());
			stmt.setString(3, convobj.getConversaTexto());
			stmt.setLong(4, convobj.getfKCliente());
			stmt.setLong(5, convobj.getIdConversa());
              
			stmt.execute();
			stmt.close();
                  
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
 
 
 
 public List<Conversa> ListaConversaPorTexto(String nome){
		try{
			List<Conversa> prosa = new ArrayList<Conversa>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblconversa where conversa_texto Like '%' ? '%'");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
			  Conversa convobj = new Conversa();
				
				
				convobj.setIdConversa(rs.getLong("idConversa"));
				convobj.setConversaAssunto(rs.getString("conversa_assunto"));
				convobj.setConversaTexto(rs.getString("conversa_texto"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("conversa_data"));
			   convobj.setConversaData(data);
               convobj.setfKCliente(rs.getLong("fkidCliente"));
				
				
				prosa.add(convobj);
			}
			rs.close();
			stmt.close();
			return prosa;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}


 public List<Conversa> ListaConversaPorAssunto(String nome){
		try{
			List<Conversa> prosa = new ArrayList<Conversa>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblconversa where conversa_assunto Like '%' ? '%'");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				
				
			  Conversa convobj = new Conversa();
				
				
				convobj.setIdConversa(rs.getLong("idConversa"));
				convobj.setConversaAssunto(rs.getString("conversa_assunto"));
				convobj.setConversaTexto(rs.getString("conversa_texto"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("conversa_data"));
			   convobj.setConversaData(data);
            convobj.setfKCliente(rs.getLong("fkidCliente"));
				
				
				prosa.add(convobj);
			}
			rs.close();
			stmt.close();
			return prosa;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
 
 
 
 
 public List<Conversa> ListaConversaPorAssuntoEid(String nome, Long id){
		try{
			List<Conversa> prosa = new ArrayList<Conversa>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblconversa where conversa_assunto Like '%' ? '%'  and fkidCliente = ?");
			stmt.setString(1, nome);
			stmt.setLong(2, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				
				
			  Conversa convobj = new Conversa();
				
				
				convobj.setIdConversa(rs.getLong("idConversa"));
				convobj.setConversaAssunto(rs.getString("conversa_assunto"));
				convobj.setConversaTexto(rs.getString("conversa_texto"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("conversa_data"));
			   convobj.setConversaData(data);
         convobj.setfKCliente(rs.getLong("fkidCliente"));
				
				
				prosa.add(convobj);
			}
			rs.close();
			stmt.close();
			return prosa;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
 
 
 public List<Conversa> ListaConversaPorTextoEid(String nome, Long id){
		try{
			List<Conversa> prosa = new ArrayList<Conversa>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblconversa where conversa_texto Like '%' ? '%'  and fkidCliente = ?");
			stmt.setString(1, nome);
			stmt.setLong(2, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				
				
			  Conversa convobj = new Conversa();
				
				
				convobj.setIdConversa(rs.getLong("idConversa"));
				convobj.setConversaAssunto(rs.getString("conversa_assunto"));
				convobj.setConversaTexto(rs.getString("conversa_texto"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("conversa_data"));
			   convobj.setConversaData(data);
      convobj.setfKCliente(rs.getLong("fkidCliente"));
				
				
				prosa.add(convobj);
			}
			rs.close();
			stmt.close();
			return prosa;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

 
 

}

 
 
 
 
 
 
 