package br.com.marquez.thiago.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.marquez.thiago.DBMysql.LogDao;
import br.com.marquez.thiago.model.Login;

@Controller
public class LoginController {
	
	
	

	 @RequestMapping(value = "loginForm")
		public String atenticacao(){
		 
		 return "formulario-login";
	 }
	
	
	
	 @RequestMapping(value = "autenticacao")
		public String atenticacao(Login usuario, HttpSession session){
		
		 
		 if(new LogDao().existeUsuario(usuario)) {
			    session.setAttribute("usuarioLogado", usuario);
			    return "redirect:ListaContatos";
		 
		 }
				
				
				 return "formulario-login";
					 
		 }

	 
	 
	 
	 @RequestMapping(value = "Logout")
	 public String logout( HttpSession session){
	 
		 session.invalidate();
		 return "formulario-login";
	 }
	 
}
