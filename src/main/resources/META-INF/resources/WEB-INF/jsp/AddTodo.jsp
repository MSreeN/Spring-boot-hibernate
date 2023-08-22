<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<title>Todos</title>
</head>
<body>
<div class = "container">
    <h1>Add a new todo </h1>
    <form action = ${methodUrl} method="post">
    <fieldset>
    <label for = "description">Description: </label>
    <input placeholder = "Enter your goal" style = "margin-bottom: 30px" name = "description" minLength = "10" type = "text"/>
    </fieldset>

    <fieldset>
        <label for = "targetDate">Target Date: </label>
        <input  name = "targetDate" type = "date"/>
    </fieldset>

    <button style = "margin-top : 30px" class = "btn btn-success">Done</button>
    <p>Todo details are : ${todoId}</p>
    <p> Url is : ${methodUrl}</p>

    </form>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
