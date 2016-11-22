package br.com.marquez.thiago.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Conversa {
	
    private Long idConversa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar conversaData;
    private String conversaAssunto;
    private String conversaTexto;
    private Long fKCliente;

    public Long getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
    }

    public Calendar getConversaData() {
        return conversaData;
    }

    public void setConversaData(Calendar conversaData) {
        this.conversaData = conversaData;
    }

    public String getConversaAssunto() {
        return conversaAssunto;
    }

    public void setConversaAssunto(String conversaAssunto) {
        this.conversaAssunto = conversaAssunto;
    }

    public String getConversaTexto() {
        return conversaTexto;
    }

    public void setConversaTexto(String conversaTexto) {
        this.conversaTexto = conversaTexto;
    }

    public Long getfKCliente() {
        return fKCliente;
    }

    public void setfKCliente(Long fKCliente) {
        this.fKCliente = fKCliente;
    }
    
    
  
   
}
