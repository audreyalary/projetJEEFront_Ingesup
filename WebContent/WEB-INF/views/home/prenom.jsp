	<div>
		<c:forEach items="${model}" var="m">
			<p>${m.firstname}</p>
		</c:forEach>
	
	</div>
	
	
	<form method="post" action="#">
		<div>
			<label>Prénom: </label>
			<input type="text" name="inputPrenom" />
		</div>
		<div>
			<input type="submit" value="OK" />
		</div>
	</form>
