<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Young Person</title>
</head>
<body>

    <h2>Person born in 1990 or later</h2>

    <jsp:useBean id="person" type="lab.mvc.model.Person" scope="request" />

    <p>First Name: <jsp:getProperty name="person" property="firstName" /></p>

    <p>Last Name: <jsp:getProperty name="person" property="lastName" /></p>

    <p>Birth Day: <jsp:getProperty name="person" property="birthDay" /></p>

    <p>Sex: <jsp:getProperty name="person" property="sex" /></p>

</body>
</html>
