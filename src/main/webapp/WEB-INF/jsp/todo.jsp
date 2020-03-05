<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title> List of Todos </title>
<link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css"
	    		rel="stylesheet">

</head>
    <body>
        <div class ="container">
            <h1>Hi ${name} </h1><br>

        <table class = "table table-striped">
            <caption> Here are the list of the Todos !! </caption>
            <thead>
                <tr>
                     <th>Description</th>
                     <th>Completion Date</th>
                     <th>Completion status</th>
                     <th>Delete Course</th>

                </tr>

            </thead>
            <tbody>
            <c:forEach items = "${todos}" var ="todo">
                <tr>
                    <td>${todo.desc}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td><a type = "button" class = "btn btn-danger" href = "/deleteTodo?id=${todo.id}">Delete</a>
                </tr>
                </c:forEach>
            </tbody>
        </table>
            <div>
                <a class ="button" href = "/addTodo"> Add your Todos</a>
            </div>
        </div>

        <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
        	    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </body>
</html>