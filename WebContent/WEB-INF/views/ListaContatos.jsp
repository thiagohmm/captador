<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <c:import url="cabecalho.jsp" />
<div class="container">
<h4>Bem Vindo ${usuarioLogado.login}</h4> 
  <h3>Lista Cliente</h3>
  <p>Lista os clientes que já estão com conversas inseridas com verde clientes que não tem conversas inseridas com vermelho.
  
  <jsp:useBean id="dao" class="br.com.marquez.thiago.DBMysql.ClienteDao"/>
  <div class="table-responsive">
<table data-toggle="table" class="table" style="table-layout:overflow" id="example">
    <thead>
      <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Telefone01</th>
        <th>Data</th>
         <th>Empresa</th>
         
      </tr>
    </thead>
    <tbody>
    
      	<c:forEach items="${Clientes}" var="cliente" >
      	<tr class="success">
      	 <td><a href="UpdateCliente/?idCliente=${cliente.idCliente}">${cliente.nomeCliente}</a></td>
      	<c:if test="${not empty cliente.emailCliente}">
        <td>${cliente.emailCliente}</td>
      </c:if>
      <c:if test="${empty cliente.emailCliente}">
        <td>Email não Informado</td>
      </c:if>
      	<td>${cliente.tel01Cliente}</td>
         <td><fmt:formatDate value="${cliente.niverCliente.time}" pattern="dd/MM/yyyy" /></td>
         <td>${cliente.empresaCliente}</td>
         <td><a href="#" onClick="popupWin();" ><img src="<c:url value="/images/remove.png"/>" alt="HTML5 Icon" style="width:18px;height:18px;"></a></td>
      	<td><a href="InsereConversa/?idCliente=${cliente.idCliente}"><img src="<c:url value="/images/conversa3.png"/>" alt="HTML5 Icon" style="width:18px;height:18px;"></a></td>
      	<td><a href="ListaConversa/?idCliente=${cliente.idCliente}"><img src="<c:url value="/images/ocultar.png"/>" alt="HTML5 Icon" style="width:18px;height:18px;"></a></td>
      	</c:forEach>
      	
      </tr>
      
      <c:forEach items="${Clientes1}" var="cliente" >
      <tr class="danger">
       
        <td><a href="UpdateCliente/?idCliente=${cliente.idCliente}">${cliente.nomeCliente}</a></td>
        
        <td>${cliente.emailCliente}</td>
        <td>${cliente.tel01Cliente}</td>
         <td><fmt:formatDate value="${cliente.niverCliente.time}" pattern="dd/MM/yyyy" /> </td>
         <td>${cliente.empresaCliente}</td>
         <td><a href="DeletaCliente/?idCliente=${cliente.idCliente}"><img src="<c:url value="/images/remove.png"/>" alt="HTML5 Icon" style="width:18px;height:18px;"></a></td>
		 <td><a href="InsereConversa/?idCliente=${cliente.idCliente}"><img src="<c:url value="/images/conversa3.png"/>" alt="HTML5 Icon" style="width:18px;height:18px;"></a></td>
		<td><a href="#" onClick="popupConv();""><img src="<c:url value="/images/ocultar.png"/>" alt="HTML5 Icon" style="width:18px;height:18px;"></a></td>
		</c:forEach>      
      </tr>
      
    </tbody>
  </table>


</div>
</div>
 <script type="text/JavaScript">
function popupWin()
{
var answer = confirm ("Não é possível deletar um contato com Conversa")
window.close();
}

$(document).ready(function() {
    $('#example').DataTable( {
        "scrollY":        "200px",
        "scrollCollapse": true,
        "paging":         false
    } );
} );


function popupConv()
{
var answer = confirm ("Não Existe uma conversa para esse contato")
window.close();
}

$(document).ready(function() {
    $('#example').DataTable( {
        "scrollY":        "200px",
        "scrollCollapse": true,
        "paging":         false
    } );
} );

</script>
</body>
</html>