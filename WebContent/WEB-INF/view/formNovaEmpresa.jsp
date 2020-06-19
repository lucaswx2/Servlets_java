<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/controlador?acao=NovaEmpresa" var="actionFormUrl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova empresa</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />
<form action="${actionFormUrl }" method="POST">
	Nome: <input type="text" name="nome" />
	Data: <input type="date" name="data" />
	<button type="submit">Enviar</button>
</form>

</body>
</html>