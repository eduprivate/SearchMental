<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<title>SearchMental - Sentiment Analizer</title>
		<body>
			<h1>SearchMental</h1>
			<div>
		
			<c:if test="${analizeResult != null}">
			<div>
				Negativo: ${analizeResult.negative} <br />
				Positivo: ${analizeResult.positive} <br />
				Score: ${analizeResult.score}
			</div>
			</c:if>
			</div>
		</body>
</html>