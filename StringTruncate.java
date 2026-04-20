/*3c(Q7). Write a Java Program for Shortening a string to a specified length and adds an ellipsis using user
defined function truncate()*/

package String_Functions;

import java.util.Scanner;

public class StringTruncate {

    // User-defined function to truncate string
    public static String truncate(String str, int length) {

        if (str == null) {
            return null;
        }

        // If string is already shorter than or equal to required length
        if (str.length() <= length) {
            return str;
        }

        // Cut the string and add ellipsis
        return str.substring(0, length) + "...";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Input required length
        System.out.print("Enter maximum length: ");
        int len = sc.nextInt();

        // Call user-defined function
        String result = truncate(input, len);

        // Display output
        System.out.println("Truncated string: " + result);

        sc.close();
    }
}
