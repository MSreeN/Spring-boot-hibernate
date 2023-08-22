<html>
<head>
<title>jsp file</title>
</head>
<body>
<%@ include file = "common/Navigation.jsp" %>
<div class = "container">
<h1>Login</h1>
<pre>${error}</pre>
<form method="post">
Name : <input type = "text" placeholder = "enter username" name = "username">
Password : <input type = "text" placeholder = "enter password" name = "password">
<button> Submit </button>
</form>
</div>
</body>
</html>