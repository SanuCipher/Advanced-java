/*8b. Build a servlet program to create a cookie to get your name through text box and press submit button(
through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
n times ( n = number of your visit ) along with the list of cookies and its setvalues and demonstrate the
expiry of cookie also.*/


package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String existingUser = null;
        int count = 0;

        Cookie[] cookies = request.getCookies();

        // Read cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        // New user
        if (existingUser == null && userName != null && !userName.isEmpty()) {
            existingUser = userName;
            count = 0;   // only first time
        
        }

        // Increment count
        if (existingUser != null) {
            count++;

            Cookie userCookie = new Cookie("user", existingUser);
            userCookie.setMaxAge(30);

            Cookie countCookie = new Cookie("count", String.valueOf(count));
            countCookie.setMaxAge(30);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        // HTML output
        out.println("<html><head><title>Cookie Example</title></head><body>");

        if (existingUser != null) {
            out.println("<h2>Welcome back, " + existingUser + "!</h2>");
            out.println("<h3>You have visited this page " + count + " times!</h3>");
        } else {
            // Redirect back to HTML page
            response.sendRedirect("input.html");
            return;
        }

        // Cookie list
        out.println("<h3>Cookies List:</h3>");
        out.println("<table border='1'>");
        out.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");

        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                out.println("<tr>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<td>" + c.getValue() + "</td>");
                out.println("</tr>");
            }
        } else {
            out.println("<tr><td colspan='2'>No Cookies Found</td></tr>");
        }

        out.println("</table>");

        out.println("<p><b>Note:</b> Cookies will expire in 30 seconds from creation.</p>");

        // Logout button
        out.println("<form method='post' action='CookieServlet'>");
        out.println("<input type='submit' value='Logout'>");
        out.println("</form>");

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Delete cookies
        Cookie userCookie = new Cookie("user", "");
        userCookie.setMaxAge(0);

        Cookie countCookie = new Cookie("count", "");
        countCookie.setMaxAge(0);

        response.addCookie(userCookie);
        response.addCookie(countCookie);

        // Go back to HTML page
        response.sendRedirect("input.html");
    }
}