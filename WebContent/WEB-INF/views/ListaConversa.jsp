<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <c:import url="cabecalho.jsp" />
<div class="container">
  <h3>Lista Conversas</h3>
  <p>Listas as conversas dos clientes.
  
  <form action="<c:url value="/DeletaConversa"/>" method="post"> 
 <c:forEach items="${Clientes}" var="cliente" >
 <td><div class="dropdown">
         <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Ações
 		 <span class="caret"></span></button>
  			<ul class="dropdown-menu">
    <li><input type="hidden" class="form-control" id="idcli" placeholder="Texto" name="idcli" value="${cliente.idCliente}" /> </li>
    <li><input type="button" class="btn btn-primary" onclick="location.href='<c:url value="/InsereConversa?idCliente=${cliente.idCliente}"/>';" value="Inserir Conversa" /></li>
    <li> <input type="submit" class="btn btn-danger" name="submit" value="Deletar Conversa"></li> 
  </ul>
  </td>
	</div>
 
 
 
 
 


</c:forEach>
<table class="table" style="overflow-y:scroll ">
    <thead>
      <tr>
         <th><input type="checkbox" id="checkBoxAll"  onClick="toggle(this)"/></th>
        <th>Assunto</th>
        <th>Data</th>
        
         
      </tr>
    </thead>
    <tbody>
    
    
  
   
      	<c:forEach items="${Conversas}" var="conversa" >
      	<div class="checkbox">
      	<tr class="">
      	<td><label><input type="checkbox" name="foo" value="${conversa.idConversa}">${conversa.idConversa}</label></td>
      	 <td><a href="<c:url value="/UpdateConversa/?idConversa=${conversa.idConversa}"/>">${conversa.conversaAssunto}</a></td>
      	 <td><fmt:formatDate value="${conversa.conversaData.time}" pattern="dd/MM/yyyy" /></td>
         <td><div class="dropdown">
         <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Conversa
 		 <span class="caret"></span></button>
  			<ul class="dropdown-menu">
    <li> <input type="hidden" class="form-control" id="texto" placeholder="Texto" name="conversaTexto" value="${conversa.conversaTexto}">${conversa.conversaTexto}</li>
    
  </ul>
  </td>
	</div>
		   
		         
      	</c:forEach>
      	
      	
      
      
 
    </tbody>
  </table>
  </form>

</div>
<script>
function toggle(source) {
	  checkboxes = document.getElementsByName('foo');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = source.checked;
	  }
	}
</script>
</body>
</html>