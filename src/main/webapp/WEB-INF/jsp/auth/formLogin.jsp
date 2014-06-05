<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario Teste</title>
</head>
<body>
	<form action="login" method="POST">

		<label for="username">Usuário:</label>
		 <input type="text" name="username">
		 
		 <label for="password">Senha:</label>
		<input type="password" name="password">
		
		<input type="submit" value="Salvar">

	</form>
	<br>
	<div style="color:red">
		${error}
	</div>
	
</body>
</html>
