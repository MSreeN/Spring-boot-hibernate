
    <%@ include file = "common/Navigation.jsp" %>
    <%@ include file = "common/Header.jsp" %>
<div class = "container">
    <table class = "table">
        <thead>
            <tr>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>is done?</th>
            <th>Update</th>
            <th> Delete </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items = "${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td> <a href = "/updateTodo?id=${todo.id}" class = "btn btn-success">Update</a></td>
                <td> <a href = "/deleteTodo?todoId=${todo.id}" class = "btn btn-warning">Delete</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class = "btn btn-success">Add todo</a>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>