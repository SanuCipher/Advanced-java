<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session Started</title>
</head>
<body>

<%
    String name = request.getParameter("username");
    String timeStr = request.getParameter("time");

    if (name != null && timeStr != null) {

        int minutes = Integer.parseInt(timeStr);

        session.setAttribute("user", name);
        session.setAttribute("minutes", minutes);

        // set expiry
        session.setMaxInactiveInterval(minutes * 60);

        Date startTime = new Date();
        session.setAttribute("startTime", startTime);

        // calculate expiry time
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        cal.add(Calendar.MINUTE, minutes);
        Date expiryTime = cal.getTime();
%>

<h2 style="color:blue;">Hello <%= name %>, Session Started!</h2>

<p><b>Session Started At:</b> <%= startTime %></p>
<p><b>Session Will Expire At:</b> <%= expiryTime %></p>

<p>Click below within <%= minutes %> minute(s) or wait to see session expiry.</p>

<a href="second.jsp">Check Session Status</a>

<%
    } else {
%>

<h2 style="color:red;">Session Expired! Please enter details again.</h2>
<a href="index.html">Go Back</a>

<%
    }
%>

</body>
</html>