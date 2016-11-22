<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


 <c:import url="cabecalho.jsp" />
 
  
<div class="container">
  <h3>Procura Conversa</h3>
  <p>Página para procurar conversas
  <br>
 <br>
 <br>

 
 <form action="SelectConversa" method="post">

 
 
 <select name="escolhecontato">
 <option value="nada"></option>
  <c:forEach items="${Clientes}" var="cliente" >
 <option value="${cliente.idCliente}">${cliente.nomeCliente}</option>
 </c:forEach>
  </select>
 
<input type="text"   name="busca" size="31" maxlength="255" value="">
<input type="submit" value="Pesquisar">
<input type="radio"  name="select" value="texto" checked>Texto
<input type="radio"  name="select" value="assunto">Assunto


</form>

<table class="table" style="overflow-y:scroll ">
    <thead>
      <tr>
         <th></th>
        <th>Assunto</th>
        <th>Data</th>
        <th></th>
        <th>Cliente</th>
        <th>Empresa</th>
         
      </tr>
    </thead>
    <tbody>
    
    
   <jsp:useBean id="dao" class="br.com.marquez.thiago.DBMysql.ClienteDao"/>
   
      	<c:forEach items="${Conversas}" var="conversa" >
      	<div class="checkbox">
      	<tr class="">
      	<c:set var="fKCliente" value="${conversa.fKCliente}"/>
      	
      	<input type="hidden" class="form-control" id="fKCliente" placeholder="" name="fKCliente" value="${conversa.fKCliente}"> 
      	<td>${conversa.idConversa}</td>
      	 <td><a href="<c:url value="/UpdateConversa/?idConversa=${conversa.idConversa}"/>">${conversa.conversaAssunto}</a></td>
      	 <td><fmt:formatDate value="${conversa.conversaData.time}" pattern="dd/MM/yyyy" /></td>
         <td><div class="dropdown">
         <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Conversa
 		 <span class="caret"></span></button>
  			<ul class="dropdown-menu">
    <li> <input type="hidden" class="form-control" id="texto" placeholder="Texto" name="conversaTexto" value="${conversa.conversaTexto}">${conversa.conversaTexto}</li>
    
  </ul>
  </td>
  <c:forEach var="cliente" items="${dao.ListaClientePorID(fKCliente)}">
  <td>${cliente.nomeCliente}</td>
  <td>${cliente.empresaCliente}</td>
  </c:forEach>
	</div>
		   
		         
      	</c:forEach>
</div>

</body>
</html>







</body>
</html>