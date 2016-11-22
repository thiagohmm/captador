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







public class ClienteDao {
private Connection connection;
	
	public ClienteDao(){
		this.connection = new ConnectionFactory().getConnection();
		
	}

    
    
    
    
    
    
   public void adiciona(Cliente cliobj){
		String sql = "INSERT INTO tblcliente(cliente_nome,cliente_email,cliente_tel01,cliente_tel02,cliente_tel03,cliente_niver,cliente_empresa,cliente_tipotel01,cliente_tipotel02,cliente_tipotel03)" +
                        " VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cliobj.getNomeCliente());
			stmt.setString(2, cliobj.getEmailCliente());
			stmt.setString(3, cliobj.getTel01Cliente());
                        stmt.setString(4, cliobj.getTel02Cliente());
                        stmt.setString(5, cliobj.getTel03Cliente());
                        stmt.setDate(6, new Date (cliobj.getNiverCliente().getTimeInMillis()));
                        stmt.setString(7, cliobj.getEmpresaCliente());
                        stmt.setString(8, cliobj.getTipotel01());
                        stmt.setString(9, cliobj.getTipotel02());
                        stmt.setString(10, cliobj.getTipotel03());
                        
                        
                        
                        
			//stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
                        
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}




public List<Cliente> getLastId(){
		try{
			List<Cliente> fregues = new ArrayList<Cliente>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblcliente WHERE idCliente = (SELECT MAX(idCliente) FROM tblcliente)");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Cliente cliobj = new Cliente();
				
				cliobj.setIdCliente(rs.getLong("idCliente"));
				cliobj.setNomeCliente(rs.getString("cliente_nome"));
				cliobj.setEmailCliente(rs.getString("cliente_email"));
				cliobj.setEmpresaCliente(rs.getString("cliente_empresa"));
                                cliobj.setTel01Cliente(rs.getString("cliente_tel01"));
                                cliobj.setTel02Cliente(rs.getString("cliente_tel02"));
                                cliobj.setTel03Cliente(rs.getString("cliente_tel03"));
                                cliobj.setTipotel01(rs.getString("cliente_tipotel01"));
                                cliobj.setTipotel02(rs.getString("cliente_tipotel02"));
                                cliobj.setTipotel03(rs.getString("cliente_tipotel03"));
                                
				
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataNascimento"));
//				contato.setDataNascimento(data);
//				
				
				
				fregues.add(cliobj);
			}
			rs.close();
			stmt.close();
			return fregues;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	


 
 
 
 
 
 
 public List<Cliente> ListaCliente(){
		try{
			List<Cliente> fregues = new ArrayList<Cliente>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblcliente");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Cliente cliobj = new Cliente();
				
				
				cliobj.setIdCliente(rs.getLong("idCliente"));
				cliobj.setNomeCliente(rs.getString("cliente_nome"));
				cliobj.setEmailCliente(rs.getString("cliente_email"));
				cliobj.setEmpresaCliente(rs.getString("cliente_empresa"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("cliente_niver"));
			   cliobj.setNiverCliente(data);
                             cliobj.setTel01Cliente(rs.getString("cliente_tel01"));
                             cliobj.setTel02Cliente(rs.getString("cliente_tel02"));
                             cliobj.setTel03Cliente(rs.getString("cliente_tel03"));
                             cliobj.setTipotel01(rs.getString("cliente_tipotel01"));
                             cliobj.setTipotel02(rs.getString("cliente_tipotel02"));
                             cliobj.setTipotel03(rs.getString("cliente_tipotel03"));
                             
				
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataNascimento"));
//				contato.setDataNascimento(data);
//				
				
				
				fregues.add(cliobj);
			}
			rs.close();
			stmt.close();
			return fregues;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
 
 
 
 
 
 
 
 
 
 public List<Cliente> ListaComConversa(){
		try{
			List<Cliente> fregues = new ArrayList<Cliente>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblcliente INNER JOIN tblconversa ON idCliente = fkidCliente "
			+ "GROUP BY tblcliente.idCliente, tblcliente.cliente_nome, tblcliente.cliente_email, tblcliente.cliente_empresa");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Cliente cliobj = new Cliente();
				
				cliobj.setIdCliente(rs.getLong("idCliente"));
				cliobj.setNomeCliente(rs.getString("cliente_nome"));
				cliobj.setEmailCliente(rs.getString("cliente_email"));
				cliobj.setEmpresaCliente(rs.getString("cliente_empresa"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("cliente_niver"));
			   cliobj.setNiverCliente(data);
				          cliobj.setTel01Cliente(rs.getString("cliente_tel01"));
                          cliobj.setTel02Cliente(rs.getString("cliente_tel02"));
                          cliobj.setTel03Cliente(rs.getString("cliente_tel03"));
                          cliobj.setTipotel01(rs.getString("cliente_tipotel01"));
                          cliobj.setTipotel02(rs.getString("cliente_tipotel02"));
                          cliobj.setTipotel03(rs.getString("cliente_tipotel03"));
                          
				
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataNascimento"));
//				contato.setDataNascimento(data);
//				
				
				
				fregues.add(cliobj);
			}
			rs.close();
			stmt.close();
			return fregues;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public List<Cliente> ListaSemConversa(){
		try{
			List<Cliente> fregues = new ArrayList<Cliente>();
			PreparedStatement stmt = connection.prepareStatement("select * from tblcliente where idCliente NOT IN (select tblconversa.fkidCliente from tblconversa)");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Cliente cliobj = new Cliente();
				
				cliobj.setIdCliente(rs.getLong("idCliente"));
				cliobj.setNomeCliente(rs.getString("cliente_nome"));
				cliobj.setEmailCliente(rs.getString("cliente_email"));
				cliobj.setEmpresaCliente(rs.getString("cliente_empresa"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("cliente_niver"));
			   cliobj.setNiverCliente(data);
				       cliobj.setTel01Cliente(rs.getString("cliente_tel01"));
                       cliobj.setTel02Cliente(rs.getString("cliente_tel02"));
                       cliobj.setTel03Cliente(rs.getString("cliente_tel03"));
                       cliobj.setTipotel01(rs.getString("cliente_tipotel01"));
                       cliobj.setTipotel02(rs.getString("cliente_tipotel02"));
                       cliobj.setTipotel03(rs.getString("cliente_tipotel03"));
                       
				
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataNascimento"));
//				contato.setDataNascimento(data);
//				
				
				
				fregues.add(cliobj);
			}
			rs.close();
			stmt.close();
			return fregues;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
 
 
 public List<Cliente> ListaClientePorID(Long id){
		try{
			List<Cliente> fregues = new ArrayList<Cliente>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblcliente where idCliente = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Cliente cliobj = new Cliente();
				
				
				cliobj.setIdCliente(rs.getLong("idCliente"));
				cliobj.setNomeCliente(rs.getString("cliente_nome"));
				cliobj.setEmailCliente(rs.getString("cliente_email"));
				cliobj.setEmpresaCliente(rs.getString("cliente_empresa"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("cliente_niver"));
			   cliobj.setNiverCliente(data);
                          cliobj.setTel01Cliente(rs.getString("cliente_tel01"));
                          cliobj.setTel02Cliente(rs.getString("cliente_tel02"));
                          cliobj.setTel03Cliente(rs.getString("cliente_tel03"));
                          cliobj.setTipotel01(rs.getString("cliente_tipotel01"));
                          cliobj.setTipotel02(rs.getString("cliente_tipotel02"));
                          cliobj.setTipotel03(rs.getString("cliente_tipotel03"));
                          
				
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataNascimento"));
//				contato.setDataNascimento(data);
//				
				
				
				fregues.add(cliobj);
			}
			rs.close();
			stmt.close();
			return fregues;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
 
 
 
 
 public void remove(Cliente cliobj) {

		

		String sql = "delete from tblcliente where idCliente = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, cliobj.getIdCliente());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
 
 

 
 
 public void altera(Cliente cliobj){
	 
		String sql = "UPDATE tblcliente set cliente_nome =?,cliente_email=?,"
				+ "cliente_tel01=?,cliente_tel02=?,cliente_tel03=?,cliente_niver=?,cliente_empresa=?,"
				+ "cliente_tipotel01=?,cliente_tipotel02=?,cliente_tipotel03=? where idCliente=?";
                     
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cliobj.getNomeCliente());
			stmt.setString(2, cliobj.getEmailCliente());
			stmt.setString(3, cliobj.getTel01Cliente());
            stmt.setString(4, cliobj.getTel02Cliente());
            stmt.setString(5, cliobj.getTel03Cliente());
            stmt.setDate(6, new Date (cliobj.getNiverCliente().getTimeInMillis()));
            stmt.setString(7, cliobj.getEmpresaCliente());
            stmt.setString(8, cliobj.getTipotel01());
            stmt.setString(9, cliobj.getTipotel02());
            stmt.setString(10, cliobj.getTipotel03());
            stmt.setLong(11, cliobj.getIdCliente());
                     
                   
                     
                     
			
			stmt.execute();
			stmt.close();
                     
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}



 public List<Cliente> ListaClientePorNome(String nome){
		try{
			List<Cliente> fregues = new ArrayList<Cliente>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblcliente where cliente_nome Like '%' ? '%'");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Cliente cliobj = new Cliente();
				
				
				cliobj.setIdCliente(rs.getLong("idCliente"));
				cliobj.setNomeCliente(rs.getString("cliente_nome"));
				cliobj.setEmailCliente(rs.getString("cliente_email"));
				cliobj.setEmpresaCliente(rs.getString("cliente_empresa"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("cliente_niver"));
			   cliobj.setNiverCliente(data);
                       cliobj.setTel01Cliente(rs.getString("cliente_tel01"));
                       cliobj.setTel02Cliente(rs.getString("cliente_tel02"));
                       cliobj.setTel03Cliente(rs.getString("cliente_tel03"));
                       cliobj.setTipotel01(rs.getString("cliente_tipotel01"));
                       cliobj.setTipotel02(rs.getString("cliente_tipotel02"));
                       cliobj.setTipotel03(rs.getString("cliente_tipotel03"));
                       
				
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataNascimento"));
//				contato.setDataNascimento(data);
//				
				
				
				fregues.add(cliobj);
			}
			rs.close();
			stmt.close();
			return fregues;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}


 
 
 public List<Cliente> ListaClientePorEmpresa(String empresa){
		try{
			List<Cliente> fregues = new ArrayList<Cliente>();
			System.out.println(empresa);
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblcliente where cliente_empresa Like '%' ? '%' ");
			stmt.setString(1, empresa);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Cliente cliobj = new Cliente();
				
				
				cliobj.setIdCliente(rs.getLong("idCliente"));
				cliobj.setNomeCliente(rs.getString("cliente_nome"));
				cliobj.setEmailCliente(rs.getString("cliente_email"));
				cliobj.setEmpresaCliente(rs.getString("cliente_empresa"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("cliente_niver"));
			   cliobj.setNiverCliente(data);
                       cliobj.setTel01Cliente(rs.getString("cliente_tel01"));
                       cliobj.setTel02Cliente(rs.getString("cliente_tel02"));
                       cliobj.setTel03Cliente(rs.getString("cliente_tel03"));
                       cliobj.setTipotel01(rs.getString("cliente_tipotel01"));
                       cliobj.setTipotel02(rs.getString("cliente_tipotel02"));
                       cliobj.setTipotel03(rs.getString("cliente_tipotel03"));
                       
				
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataNascimento"));
//				contato.setDataNascimento(data);
//				
				
				
				fregues.add(cliobj);
			}
			rs.close();
			stmt.close();
			return fregues;
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
 
 
 
 
 public boolean VerificaClienteSemConversa(Long id){
	 boolean ver = false;
		try{
			
			PreparedStatement stmt = connection.prepareStatement("SELECT capcli.tblcliente.idCliente from capcli.tblcliente where capcli.tblcliente.idCliente=?  and exists (select capcli.tblconversa.fkidCliente from tblconversa where capcli.tblconversa.fkidCliente=capcli.tblcliente.idCliente)");
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			ver=rs.next();
		
			
			rs.close();
			stmt.close();
			
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		return ver;
 }
 
 

}
