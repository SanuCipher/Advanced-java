/*8b. Build a servlet program to create a cookie to get your name through text box and press submit button(
through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
n times ( n = number of your visit ) and demonstrate the expiry of cookie also.*/

package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        // visit counter
        int count = 0;
        if (session.getAttribute("count") != null) {
            count = (int) session.getAttribute("count");
        }

        // check cookie
        Cookie[] cookies = request.getCookies();
        String existingUser = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    existingUser = cookie.getValue();
                    break;
                }
            }
        }

        out.println("<html><body>");

        // IMPORTANT: only show welcome back if session login exists
        String loginStatus = (String) session.getAttribute("loggedIn");

        if (existingUser != null && !existingUser.equals("") && loginStatus != null) {

            // reset login flag after showing once
            session.removeAttribute("loggedIn");

            count++;
            session.setAttribute("count", count);

            out.println("<font color='blue'><h2>Welcome back, " + existingUser + "!</h2></font>");
            out.println("<font color='magenta'><h2>You have visited this page " + count + " times!</h2></font>");

        } else {

            // ✅ YOUR REQUIRED LINE (KEPT EXACT)
            out.println("<h2 style='color:red;'>Welcome Guest! you have been logged out or kindly login first time</h2>");

            out.println("<form action='CookieServlet' method='post'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        if (userName != null && !userName.trim().isEmpty()) {

            // create cookie
            Cookie cookie = new Cookie("user", userName);
            cookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(cookie);

            // mark login in session
            HttpSession session = request.getSession();
            session.setAttribute("loggedIn", "yes");
        }

        response.sendRedirect("CookieServlet");
    }
}
