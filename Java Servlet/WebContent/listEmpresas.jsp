<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/removeEmpresa" var="removeEmpresa" />
<c:url value="/mostraEmpresa" var="mostraEmpresa" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<c:if test="${not empty empresa}">
            Empresa ${ empresa } cadastrada com sucesso!
    </c:if>


	Lista de empresas:
	<br />

	<ul>
		<c:forEach items="${empresas}" var="empresa">

			<li>
				${empresa.nome }-<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" /> 
				<a href="${mostraEmpresa}?id=${empresa.id}">Editar</a> 
				<a href="${removeEmpresa}?id=${empresa.id}">Remover</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>