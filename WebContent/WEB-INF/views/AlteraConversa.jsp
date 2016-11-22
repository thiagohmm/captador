<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


 <c:import url="cabecalho.jsp" />

  
<div class="container">
  <h3>Altera Conversa</h3>
  <p>Página para alterar as conversas de clientes
 
  <form action="<c:url value="/AlteraConversa"/>" method="post">
  
 <div class="form-group">
 <c:forEach items="${Conversa}" var="conversa" >
  <input type="hidden" class="form-control" id="fKCliente" placeholder="" name="fKCliente" value="${conversa.fKCliente}">
  <input type="hidden" class="form-control" id="idConversa" placeholder="" name="idConversa" value="${conversa.idConversa}">
   <label for="nome">Assunto:</label>
  <input type="text" class="form-control" id="assunto" placeholder="Assunto" name="conversaAssunto" value="${conversa.conversaAssunto}">

<br />
  <div class="form-group">
  <label for="comment">Conversa:</label>
  <textarea class="form-control" rows="5" id="comment"  placeholder="Texto" name="conversaTexto">${conversa.conversaTexto}</textarea>
</div>
<br />

<div class="col-xs-2">
 <label for="DataConversa">Data Convesa:</label>
    <input type="date" class="form-control" placeholder=""  name="conversaData" id="datepicker" value="<fmt:formatDate value="${conversa.conversaData.time}" pattern="yyyy-MM-dd" />" required>
   
        

 

<br />
</div>

</c:forEach>
 

</div>
<button type="submit" class="btn btn-primary btn-block" >Altera Cliente</button>
</form>
<script>
  $( function() {
    $( "#datepicker" ).datepicker({dateFormat: 'yy-mm-dd'});
  } );
  </script>
</body>
</html>