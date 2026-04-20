<%@ page import="java.sql.*" %>

<html>
<body>

<h2>Salary Report</h2>
<hr>

<%
int total = 0;

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee",
        "root",
        "Noor2006"
    );

    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM Emp");

    while(rs.next()) {

        int no = rs.getInt("Emp_NO");
        String name = rs.getString("Emp_Name");
        int sal = rs.getInt("Basicsalary");

        total += sal;

%>

<pre>
Emp_No   : <%= no %>
Emp_Name : <%= name %>
Basic    : <%= sal %>
-----------------------------------------
</pre>

<%
    }

%>

<h3>Grand Salary: <%= total %></h3>

<%
    rs.close();
    con.close();

} catch(Exception e) {
    out.println("Error: " + e);
}
%>

</body>
</html>