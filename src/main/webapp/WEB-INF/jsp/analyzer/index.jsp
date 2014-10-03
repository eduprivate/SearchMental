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
		</body>
</html>