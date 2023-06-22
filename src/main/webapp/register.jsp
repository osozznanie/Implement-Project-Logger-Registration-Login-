<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>


<%--@declare id="level"--%>
<form action="register" method="post">

    <%--@declare id="firstname"--%><%--@declare id="lastname"--%><%--@declare id="email"--%><%--@declare id="password"--%>
    <label for="firstName">
        First Name :
    <input name="firstName">
</label>
    <br>
    <label for="lastName">Last Name :</label> <input name="lastName">
    <br>
    <label for="email">Email :</label> <input name="email">
    <br>
    <label for="password">Password : </label> <input name="password">
    <br>
        <input type="submit" value="submit">
        <br>
        <p>Select your level</p>
        <label for="level">
            <select name="userType">
                <option for="admin" value="admin">Admin</option>
                <option for="user" value="user">User</option>
            </select>
        </label>
</form>



</body>
</html>