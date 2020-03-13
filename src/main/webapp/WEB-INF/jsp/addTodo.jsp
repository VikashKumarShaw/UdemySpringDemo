<%@ include file = "common/header.jspf" %>
<%@ include file = "common/navigation.jspf" %>

    <div class = "container">
        <h2>Hi ${name}</h2> <br>

            <h3>Add the list of the Todos !!</h3>
        <br>

            <form:form method = "POST" modelAttribute = "todo">
                <form:hidden path = "id"/>
                <fieldset class = "form-group">
                    <form:label path = "desc">Description</form:label>
                    <form:input type = "text" path = "desc"  class = "form-control" required ="required"/>
                    <form:errors path = "desc" cssClass = "text-warning" />
                </fieldset>

                <fieldset class = "form-group">
                    <form:label path = "targetDate">Completion Date</form:label>
                    <form:input type = "text" path = "targetDate"  class = "form-control" required ="required"/>
                    <form:errors path = "targetDate" cssClass = "text-warning" />
                </fieldset>

                <button type = "submit" class ="btn btn-primary">Add</button>
            </form:form>
     </div>

<%@ include file = "common/footer.jspf" %>
