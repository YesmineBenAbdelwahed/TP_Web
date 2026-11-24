<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP Scriptlet</title>
</head>
<body>

    <h2>JSP Scriptlet</h2>

    <%
        java.util.Date currentDate = new java.util.Date();
        String serverIP = request.getRemoteHost();
    %>

    <p>Current date and time: <%= currentDate %></p>

    <p>Server's IP address: <%= serverIP %></p>

</body>
</html>
