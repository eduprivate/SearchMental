<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:setLocale value="en_US"/>
<html>
<head>
	<title>SearchMental - Sentiment Analizer</title>
		<body>
			<h1>SearchMental</h1>
			<div>
		
			<c:if test="${statisticAnalizeResult != null}">
			<div>
				Resultado: <br />
				<div><label style="color:#FF0000; font-weight:bold;">Negativo: <fmt:formatNumber type="number" groupingUsed="false" maxFractionDigits="2" value="${statisticAnalizeResult.negativePercent}" /> %</label></div><br />
				<div><label style="color:#00FF00; font-weight:bold;">Positivo:  <fmt:formatNumber type="number" groupingUsed="false" maxFractionDigits="2" value="${statisticAnalizeResult.positivePercent}" />%</label></div><br />
				
			</div>
			</c:if>
			</div>
		</body>
</html>