<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
    </head>

    <body>

        <%
            String name = request.getParameter("uname");
            int time = Integer.parseInt(request.getParameter("time"));

            // Greeting
            out.print("Hello " + name + "!");

            // Store in session
            session.setAttribute("user", name);

            // Set session expiry (user-defined)
            session.setMaxInactiveInterval(time);

            out.print("<br>Session started...");
            out.print("<br>Session expiry time: " + time + " seconds");

            out.print("<br><br>Click below link within the given time or wait to check expiry<br>");
        %>

        <br>
        <a href="second.jsp">Check Session</a>

    </body>
</html>