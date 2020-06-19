<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/controlador?acao=AlteraEmpresa&id=${empresa.id}" var="actionFormUrl" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />
<form action="${actionFormUrl }" method="POST">
	Nome: <input type="text" name="nome"  value="${empresa.nome}"/>
	Data: <input type="date" name="data" value='<fmt:formatDate value="${empresa.dataAbertura }" pattern="yyyy-MM-dd"/>'/>
	<button type="submit">Atualizar</button>
</form>


</body>
</html>