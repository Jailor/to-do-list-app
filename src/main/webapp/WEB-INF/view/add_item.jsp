<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<%@ page import ="andrei.util.AttributeNames" %>
<html>
<head>
    <title>Add Item</title>
</head>
<body>
    <div align="center">
        
       <%--@elvariable id="${AttributeNames.TODO_ITEM}" type="andrei.model.TodoItem"--%>
       <form:form method="POST" modelAttribute="${AttributeNames.TODO_ITEM}">
           <table>
               <!-- table works fine w/o id-->
               <tr>
                   <td><label>ID</label></td>
                   <td> <!-- name from form must perfectly match, disabled means field is not editable-->
                       <form:input path="id" disabled="true" />
                   </td>
               </tr>
               <tr>
                   <td><label>Title</label></td>
                   <td><form:input path="title"/></td>
               </tr>
               <tr>
                   <td><label>Deadline</label></td>
                   <td><form:input path="deadline"/></td>
               </tr>
               <tr>
                   <td><label>Details</label></td>
                   <td><form:textarea path="details"/></td>
               </tr>
               <!-- will submit the form-->
               <tr>
                   <td><input type="submit" value="Submit"/></td>
               </tr>
           </table>
       </form:form>
    </div>
</body>
</html>