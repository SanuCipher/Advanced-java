/*3c(8). Write a Java Program for Verifying if a string contains only numeric characters using user defined
function isNumeric()*/


package String_Functions;

import java.util.Scanner;

public class NumericCheck {

    // User-defined function
    public static boolean isNumeric(String str) {

        // Check for null or empty string
        if (str == null || str.trim().isEmpty()) {
            return false;
        }

        // Check each character
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false; // if any non-digit found
            }
        }

        return true; // all characters are digits
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Call function
        if (isNumeric(input)) {
            System.out.println("The string contains ONLY numeric characters.");
        } else {
            System.out.println("The string does NOT contain only numeric characters.");
        }

        sc.close();
    }
}
