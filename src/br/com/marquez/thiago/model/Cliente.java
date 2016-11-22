package br.com.marquez.thiago.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Cliente {
	   
	   private Long idCliente;
	   private String nomeCliente;
	   private String emailCliente;
	   private String tel01Cliente;
	   private String tel02Cliente;
	   private String tel03Cliente;
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	   private Calendar niverCliente;
	   private String empresaCliente;
	   private String tipotel01;
	   private String tipotel02;
	   private String tipotel03;

	   
	    public Long getIdCliente() {
	        return idCliente;
	    }

	    public void setIdCliente(Long idCliente) {
	        this.idCliente = idCliente;
	    }

	    public String getNomeCliente() {
	        return nomeCliente;
	    }

	    public void setNomeCliente(String nomeCliente) {
	        this.nomeCliente = nomeCliente;
	    }

	    public String getEmailCliente() {
	        return emailCliente;
	    }

	    public void setEmailCliente(String emailCliente) {
	        this.emailCliente = emailCliente;
	    }

	    public String getTel01Cliente() {
	        return tel01Cliente;
	    }

	    public void setTel01Cliente(String tel01Cliente) {
	        this.tel01Cliente = tel01Cliente;
	    }

	    public String getTel02Cliente() {
	        return tel02Cliente;
	    }

	    public void setTel02Cliente(String tel02Cliente) {
	        this.tel02Cliente = tel02Cliente;
	    }

	    public String getTel03Cliente() {
	        return tel03Cliente;
	    }

	    public void setTel03Cliente(String tel03Cliente) {
	        this.tel03Cliente = tel03Cliente;
	    }

	    public Calendar getNiverCliente() {
	        return niverCliente;
	    }

	    public void setNiverCliente(Calendar date) {
	        this.niverCliente = date;
	    }

	    public String getEmpresaCliente() {
	        return empresaCliente;
	    }

	    public void setEmpresaCliente(String empresaCliente) {
	        this.empresaCliente = empresaCliente;
	    }

	    public String getTipotel01() {
	        return tipotel01;
	    }

	    public void setTipotel01(String tipotel01) {
	        this.tipotel01 = tipotel01;
	    }

	   
	 public String getTipotel02() {
	        return tipotel02;
	    }

	    public void setTipotel02(String tipotel02) {
	        this.tipotel02 = tipotel02;
	    }

	    public String getTipotel03() {
	        return tipotel03;
	    }

	    public void setTipotel03(String tipotel03) {
	        this.tipotel03 = tipotel03;
	    }
	    
	    
	   
	}
