<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP Declaration</title>
</head>
<body>

    <h2>A random list from 1 to 100:</h2>

    <%! 
        private int numEntries = 10;

        private int randomInt(int range) {
            return (1 + ((int)(Math.random() * range)));
        }
    %>

    <ul>
        <%
            for (int i = 0; i < numEntries; i++) {
        %>
                <li><%= randomInt(100) %></li>
        <%
            }
        %>
    </ul>

</body>
</html>
