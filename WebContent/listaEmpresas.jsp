<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/formNovaEmpresa.jsp" var="novaEmpresaUrl" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de Empresas</title>
</head>
<body>


	<ul>

		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome } - <fmt:formatDate
					value="${empresa.dataAbertura }" /> 
					<a
				href="<c:url value="/removeEmpresa?id=${empresa.id }"/>">Remover</a>
				
							<a
				href="<c:url value="/editEmpresa?id=${empresa.id }"/>">Editar</a>
			</li>
		</c:forEach>

	</ul>
	<a href='${novaEmpresaUrl }'> Nova </a>
</body>
</html>