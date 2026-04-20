<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Session Check</title>
    </head>

    <body>

        <h2>Session Result</h2>

        <%
            String name = (String) session.getAttribute("user");

            if (name == null) {
                out.print("Sorry! Session has expired");
            } else {
                out.print("Hello " + name + "!");
            }
        %>

    </body>
</html>