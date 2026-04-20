<%@ page import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>Cookie Added</title>
</head>
<body>

<%
    String name = request.getParameter("cookieName");
    String domain = request.getParameter("cookieDomain");
    int maxAge = Integer.parseInt(request.getParameter("maxAge"));

    Cookie cookie = new Cookie(name, "SampleValue");
    cookie.setDomain(domain);
    cookie.setMaxAge(maxAge);

    response.addCookie(cookie);
%>

<h2>Cookie Added Successfully!</h2>

<p><b>Name:</b> <%= name %></p>
<p><b>Domain:</b> <%= domain %></p>
<p><b>Max Age:</b> <%= maxAge %> seconds</p>

<br>
<a href="viewCookies.jsp">Go to Active Cookie List</a>

</body>
</html>