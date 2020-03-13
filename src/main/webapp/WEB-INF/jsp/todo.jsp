<%@ include file = "common/header.jspf"%>
<%@ include file = "common/navigation.jspf"%>

      <div class ="container">
            <h1>Hi ${name} </h1><br>

        <table class = "table table-striped">
            <caption> Here are the list of the Todos !! </caption>
            <thead>
                <tr>
                     <th>Description</th>
                     <th>Completion Date</th>
                     <th>Completion status</th>
                     <th>Update Course</th>
                     <th>Delete Course</th>


                </tr>

            </thead>
            <tbody>
            <c:forEach items = "${todos}" var ="todo">
                <tr>
                    <td>${todo.desc}</td>
                    <td><fmt:formatDate value = "${todo.targetDate}"/></td>
                    <td>${todo.done}</td>
                    <td><a type = "button" class = "btn btn-success" href = "/updateTodo?id=${todo.id}">Update</a>
                    <td><a type = "button" class = "btn btn-danger" href = "/deleteTodo?id=${todo.id}">Delete</a>

                </tr>
                </c:forEach>
            </tbody>
        </table>
            <div>
                <a class ="button" href = "/addTodo"> Add your Todos</a>
            </div>
        </div>
<%@ include file = "common/footer.jspf"%>
