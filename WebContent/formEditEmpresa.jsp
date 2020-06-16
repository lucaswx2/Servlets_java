<!DOCTYPE html>

<c:url value="/editEmpresa?id=${empresa.id}" var="actionFormUrl" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>

<form action="${actionFormUrl }" method="POST">
	Nome: <input type="text" name="nome"  value="${empresa.nome}"/>
	Data: <input type="date" name="data" value='<fmt:formatDate value="${empresa.dataAbertura }" pattern="yyyy-MM-dd"/>'/>
	<button type="submit">Atualizar</button>
</form>


</body>
</html>