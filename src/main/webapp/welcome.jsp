<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Welcome Page</title>
    </head>

    <body>

        <%
            String name = request.getParameter("uname");

            out.print("Welcome! " + name);
            out.print("<br>Session has started ... " + name);

            // store in session
            session.setAttribute("user", name);

            out.print("<br>Your name has been stored in session object");

            // set expiry time = 60 seconds
            session.setMaxInactiveInterval(60);

            out.print("<br>One minute is set for the session expiry");

            out.print("<br>Click the link below within one minute or wait to check session expiry<br>");
        %>

        <a href="second.jsp">Display the value</a>

    </body>
</html>