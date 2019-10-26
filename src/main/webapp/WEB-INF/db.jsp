<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="addUser">
    Name: <input type="text" name="name" /><br />
    Age: <input type="number" name="age" /><br />
    Phone: <input type="text" name="phone" /><br />
    Adress: <input type="text" name="address" /><br />
    <input type="submit" name="add" value="Add new user" />
</form>

<form method="get" action="viewUser">
    <input type="submit" name="view" value="Show users" />
</form>
<h2>Users </h2>
<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Phone</th>
        <th>Address</th>
    </tr>
    <c:forEach var="user" items="${usersList}">
        <tr>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.phone}</td>
            <td>${user.address}</td>
        </tr>
    </c:forEach>
</table>






