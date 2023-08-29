<%@ include file = "common/Header.jsp" %>
<%@ include file = "common/Navigation.jsp" %>
<div class = "container">
    <h1>Add a new todo </h1>
    <form action = ${methodUrl} method="post">
    <fieldset>
    <label for = "description">Description: </label>
    <input placeholder = "Enter your goal" style = "margin-bottom: 30px" name = "description" minLength = "10" type = "text"/>
    </fieldset>

    <fieldset>
        <label for = "targetDate">Target Date: </label>
        <input name = "targetDate" type = "date" required/>
    </fieldset>

    <button type = "submit" style = "margin-top : 30px" class = "btn btn-success">Done</button>

    </form>

    <p> ${methodUrl} </p>
    <p> ${todoId} </p>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
