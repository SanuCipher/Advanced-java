<html>
<head>
    <title>Cookie Management</title>
</head>
<body>
    <h2>Add Cookie</h2>
    <form action="addCookie.jsp" method="post">
        Name: <input type="text" name="cookieName" required><br><br>
        Domain: <input type="text" name="cookieDomain" required><br><br>
        Max Expiry Age (in sec): <input type="number" name="maxAge" required><br><br>
        
        <input type="submit" value="Add Cookie">
    </form>
</body>
</html>