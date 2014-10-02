<html>
<head>
	<title>SearchMental - Sentiment Analizer</title>
		<body>
			<h1>SearchMental</h1>
			<div>
			<form action="/analyzer">
			    Digite um termo:
			    <input type="text" max="255" maxlength="50" name="queryTerm" id="queryTerm">
			    <input type="submit" name="enviar"  title="enviar"/>
			</form>
			</div>
		
			<c:if test="${result != null}">
			<div>
				Negativo: ${result.negative} <br />
				Positivo: ${result.positive} <br />
				Score: ${result.score}
			</div>
			</c:if>
		</body>
</html>