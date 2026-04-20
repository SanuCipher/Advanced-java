/*6c. Build a servlet program to check the given number is prime number or not using HTML with step by
step procedure.*/

package com.primecheck;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int num = Integer.parseInt(request.getParameter("num"));
        boolean isPrime = true;

        String steps = "Checking divisibility:<br>";

        if (num <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                steps += num + " ÷ " + i + "<br>";

                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        out.println("<html><body>");
        out.println("<h2>Result</h2>");
        out.println("<p>Number: " + num + "</p>");
        out.println("<p>" + steps + "</p>");

        if (isPrime) {
            out.println("<h3>" + num + " is a Prime Number</h3>");
        } else {
            out.println("<h3>" + num + " is NOT a Prime Number</h3>");
        }

        out.println("</body></html>");
    }

    // To avoid 405 error
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
}