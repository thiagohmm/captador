package br.com.marquez.thiago.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import br.com.marquez.thiago.DBMysql.ClienteDao;
import br.com.marquez.thiago.DBMysql.ConversaDao;
import br.com.marquez.thiago.DBMysql.LogDao;
import br.com.marquez.thiago.model.Cliente;
import br.com.marquez.thiago.model.Conversa;
import br.com.marquez.thiago.model.Login;

@Controller
public class SistemaController {
	
	 @RequestMapping(value = "/olaMundoSpring", method = RequestMethod.GET)
	public String execute(){
		 return "ok";
	 
	 }
	 
	 
	
	 
	 @InitBinder
	 protected void initBinder(WebDataBinder binder) {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true) );
	 }

	 
	
	
	 
	 
	 @RequestMapping(value = "/ListaContatos")
	 public String lista (Model model){
		 
		 ClienteDao dao = new ClienteDao();
		 model.addAttribute("Clientes", dao.ListaComConversa());
		 model.addAttribute("Clientes1", dao.ListaSemConversa());
		 return "ListaContatos";
	 }
	 
	 
	 
	 @RequestMapping(value = "/adicionaCliente")
	 public String adicionaCliente(){
		
		 
		 return "InserirCliente";
	 }
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/InserirCliente")
	 public String inserirCliente(Cliente cli){
		 ClienteDao dao = new ClienteDao();
		 dao.adiciona(cli);
		 System.out.println("foi adicionado");
		 return "InserirCliente";
	 }
	 
	 
	 
	
	 
	 
	 @RequestMapping(value ="/DeletaCliente", method = RequestMethod.GET)
	 public String deletaCliente(Cliente cli) {
	   ClienteDao dao = new ClienteDao();
	   dao.remove(cli);
	   return "redirect:/ListaContatos";
	 }
	 
	 
	 
	 @RequestMapping(value = "/UpdateCliente")
	 public String updateCliente(Long idCliente, Model model){
		
		 ClienteDao dao = new ClienteDao();
		 model.addAttribute("Clientes", dao.ListaClientePorID(idCliente));
		 return "AlteraCliente";
	 }
	 
	 
	 @RequestMapping(value = "/AlteraCliente")
	 public String updateCliente(Cliente cli){
		ClienteDao dao = new ClienteDao();
		 dao.altera(cli);
		 return "redirect:/ListaContatos";
	 }
	 
	
	 
	 @RequestMapping(value = "/InsereConversa")
	 public String insereConvera(Long idCliente, Model model){
		 ClienteDao dao = new ClienteDao();
		 model.addAttribute("Clientes", dao.ListaClientePorID(idCliente));
		 return "InsereConversa";
	 }
	 
	 
	 @RequestMapping(value = "/InsertConversa")
	 public String insertConversa(Conversa conv){
		 ConversaDao dao = new ConversaDao();
		 dao.adicionaConversa(conv);
		 System.out.println("foi adicionado");
		 return "redirect:/ListaContatos";
	 }
	 
	 
	 @RequestMapping(value = "ProcuraCliente")
	 public String procuraCliente(){
		
		 
		 return "ProcuraCliente";
	 }
	 
	 
	 @RequestMapping(value = "/SelectCliente")
	 public String  busca(@RequestParam String busca, Model model, @RequestParam String select){
						 
		 ClienteDao dao = new ClienteDao();
		 //Cliente cli = new Cliente();
		 
		 System.out.println(select);
		 System.out.println(busca);
		 
		 if (select.equals("nome")){
			 model.addAttribute("Clientes", dao.ListaClientePorNome(busca)); 
			// for (int i=0 ; i<dao.ListaClientePorNome(busca).size(); i++) {
			//	 cli.setIdCliente(dao.ListaClientePorNome(busca).get(i).getIdCliente());	
		//	}
			// System.out.println(cli.getIdCliente());
			 
		 }else{
		 
		 
		 model.addAttribute("Clientes", dao.ListaClientePorEmpresa(busca));
		 }
		 return "SelectCliente";
	 }

	 
	 
	
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/ListaConversa")
	 public String listaConvera(Long idCliente, Model model){
		 ConversaDao daoconversa = new ConversaDao();
		 ClienteDao dao = new ClienteDao();
		 Cliente cli = new Cliente();
		 model.addAttribute("Conversas", daoconversa.ListaConversaPorfk(idCliente));
		 model.addAttribute("Clientes", dao.ListaClientePorID(idCliente));
		 return "ListaConversa";
	 }
	 
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value = "DeletaConversa", method = RequestMethod.POST)
	 public String  deletaconversa(HttpServletRequest request, ModelMap modelmap,  @RequestParam String idcli){
			ConversaDao convdao = new ConversaDao();
			System.out.println(idcli);
			
		try{
			if(request.getParameterValues("foo") !=null){
			for(String foo :request.getParameterValues("foo")){
				convdao.remove(Long.parseLong(foo));
			  }
			}
		  		
		return "redirect:/ListaConversa/?idCliente=" + idcli;
	 }catch (Exception e){
		modelmap.put("error", e.getMessage());
		return "redirect:/ListaContatos";
	 }
	 
	 
}
	 
	 @RequestMapping(value = "UpdateConversa", method=RequestMethod.GET)
	 public String updateConversa(Long idConversa, Model model){
		 ConversaDao dao = new ConversaDao();
		 model.addAttribute("Conversa", dao.listaConversaPorID(idConversa));
		 return "AlteraConversa";
	 }
	 
	 
	 @RequestMapping(value = "AlteraConversa")
	 public String alteraConversa(Conversa conv, Long fKCliente){
		ConversaDao dao = new ConversaDao();
		 dao.alteraConversa(conv);
		 return "redirect:/ListaConversa/?idCliente=" + fKCliente;
	 }
	 
	 
	 
	 @RequestMapping(value = "ProcuraConversa")
	 public String procuraConversa(Model model){
	
	ClienteDao dao = new ClienteDao();
	model.addAttribute("Clientes", dao.ListaComConversa());
		 
		 return "ProcuraConversa";
	 }
	 
	 
	 @RequestMapping(value = "SelectConversa")
	 public String  buscaConversa(@RequestParam String busca, Model model, @RequestParam String select, @RequestParam String escolhecontato){
						 
		
		 ConversaDao contdao = new ConversaDao();
		 ClienteDao clidao = new ClienteDao();
		 System.out.println(escolhecontato);
		 
		 model.addAttribute("Clientes", clidao.ListaComConversa());	 
		 if(busca != null){
			 
		 if (select.equals("texto") && escolhecontato.equals("nada")){
			 
			model.addAttribute("Conversas", contdao.ListaConversaPorAssunto(busca)); 
			 
		 } 
		 
		 if (select.equals("assunto") && escolhecontato.equals("nada")){
		 
			 model.addAttribute("Conversas", contdao.ListaConversaPorTexto(busca)); 
 			 
					
		 }
		 
		 
		 if (select.equals("assunto") && !escolhecontato.equals("nada")){
			 
			 model.addAttribute("Conversas", contdao.ListaConversaPorAssuntoEid(busca, Long.parseLong(escolhecontato))); 
 			 
					
		 }
		 
		 	if (select.equals("texto") && !escolhecontato.equals("nada")){
			 
			 model.addAttribute("Conversas", contdao.ListaConversaPorTextoEid(busca, Long.parseLong(escolhecontato))); 
 			 
					
		 }
		 
		 
}
		 return "SelectConversa";
	 }

	 
	 @RequestMapping(value = "AdmUser")
	 public String AdmUser(Model model){
		LogDao  userdao = new LogDao();
		 model.addAttribute("Usuario", userdao.ListaLogin());
		 return "AdmUser";
	 }
	 
	 
	 @RequestMapping(value = "InseriLogin")
	 public String insertLogin(Login logobj){
		 LogDao dao = new LogDao();
		 
		 if (dao.verificaUsuario(logobj) == true){
			 
			 return "popupexiste";
		 }else{
		 
		 
		 dao.adicionaLogin(logobj);
		 return "redirect:/AdmUser";
		 		}
	 }
	 	 
	 @RequestMapping(value ="/DeletaLogin", method = RequestMethod.GET)
	 public String deletaLogin(Login logobj){
	 LogDao dao = new LogDao();
	 dao.deletaLogin(logobj);
	 return "redirect:/AdmUser";
	 }
	 
}
