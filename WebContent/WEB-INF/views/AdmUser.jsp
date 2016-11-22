<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


 <c:import url="cabecalho.jsp" />
 
  
<div class="container">
  <h3>Gerencia Usuários</h3>
  <p>Página para gerenciar usuários
  <br>
 <br>
 <br>

 
<div class="container">
  <form  action="InseriLogin" method="post"  name="form1">
    <div class="form-group row">
      <label for="user" class="col-sm-2 col-form-label">Usuário</label>
      <div class="col-sm-3">
        <input type="text" class="form-control" id="user" onBlur="return valida(this);" placeholder="Usuário" name="login" onkeypress="return veri(event);">
      </div>
    </div>
    <div class="form-group row">
      <label for="txtPassword" class="col-sm-2 col-form-label">Password</label>
      <div class="col-sm-3">
       <input type="text" class="form-control" id="txtPassword" placeholder="Senha" name="senha">
       <meter value="0" id="PassValue" max="100"></meter>
      </div>
    </div>
        
    <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Cadastrar</button>
      </div>
    </div>
  </form>
<br>
<br>
<br>
<h4>Clique para deletar os logins</h4>
<div class="list-group">
 <a href="#" class="list-group-item active"></a>
<c:forEach items="${Usuario}" var="log" >  
  <a href="DeletaLogin/?idLogin=${log.idLogin}" class="list-group-item">${log.idLogin} ${log.login}</a>
  </c:forEach>
  
</div>



<script type="text/javascript"> 
$(function () { 
	$("#txtPassword").complexify({}, function (valid, complexity) {
		document.getElementById("PassValue").value = complexity; 
		}); 
	}); 
	
	

function ini(){

	document.form1.textaaa.focus();

	}

	function veri(objEvent){

	keyascii = objEvent.keyCode;

	if (keyascii == 32){

	return false;

	}else{

	return true;

	}

	}
</script>


</body>
</html>