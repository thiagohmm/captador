<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


 <c:import url="cabecalho.jsp" />
 
  
<div class="container">
  <h3>Procura Cliente Cliente</h3>
  <p>Página para procurar clientes
 
  <form action="" method="post">
 
<input type="radio"  name="select" value="nome" checked>Nome do Cliente
<input type="radio"  name="select" value="empresa">Empresa Cliente
<input type="text"   name="busca" size="31" maxlength="255" value="">
<input type="submit" value="Pesquisar">

</form> 
<table class="table" style="overflow-y:scroll ">
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
     <jsp:useBean id="dao" class="br.com.marquez.thiago.DBMysql.ClienteDao"/>
     
     
      	<c:forEach items="${Clientes}" var="cliente" >
      	<tr class="info">
      	<c:set var="idCliente" value="${cliente.idCliente}"/>
      	<input type="hidden" class="form-control" id="idCliente" placeholder="" name="idCliente" value="${cliente.idCliente}"> 
      	
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
         <td><a href="InsereConversa/?idCliente=${cliente.idCliente}"><img src="<c:url value="/images/conversa3.png"/>" alt="HTML5 Icon" style="width:18px;height:18px;"></a></td>
         
        
         <c:if test="${dao.VerificaClienteSemConversa(idCliente) == true}">
         <td> </td>
         <td><a href="ListaConversa/?idCliente=${cliente.idCliente}"><img src="<c:url value="/images/ocultar.png"/>" alt="HTML5 Icon" style="width:18px;height:18px;"></a></td>
         </c:if>
         
         
         
          <c:if test="${dao.VerificaClienteSemConversa(idCliente) == false}">
         <td><a href="DeletaCliente/?idCliente=${cliente.idCliente}"><img src="<c:url value="/images/remove.png"/>" alt="HTML5 Icon" style="width:18px;height:18px;"></a></td>
         <td><a href="#" onClick="popupConv();""><img src="<c:url value="/images/ocultar.png"/>" alt="HTML5 Icon" style="width:18px;height:18px;"></a></td></a></td>
         </c:if>
      	</c:forEach>
      	
      </tr>
      
          
    </tbody>
  </table>



</div>
 <script type="text/JavaScript">
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