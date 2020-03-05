<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title> List of Todos </title>
<link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css"
	    		rel="stylesheet">

</head>
    <body>
    <h2>Hi ${name}</h2> <br>
    <div class = "container">
       <h3>Add the list of the Todos !!</h3>
        <br>

    <form:form method = "POST" modelAttribute = "todo">
        <fieldset class = "form-group">
            <form:label path = "desc">Description</form:label>
            <form:input type = "text" path = "desc"  class = "form-control" required ="required"/>
        </fieldset>

        <button type = "submit" class ="btn btn-primary">Add</button>
        </form:form>
        </div>

        <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
        	    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </body>
</html>