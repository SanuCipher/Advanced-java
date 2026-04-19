/*Q5. Write a Java Program for Eliminating all whitespace characters from a string using user defined
function removeWhitespace()*/

package String_Functions;

import java.util.Scanner;

public class RemoveWhitespace {

    // User-defined function to remove whitespace
    public static String removeWhitespace(String str) {

        if (str == null) {
            return null;
        }

        // Step 1: Remove all whitespace characters (spaces, tabs, etc.)
        String result = str.replaceAll("\\s", "");

        return result;
    }

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Input string from user
        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();

        // Call user-defined function
        String output = removeWhitespace(input);

        // Display result
        System.out.println("String after removing whitespace: " + output);

        // Close scanner
        sc.close();
    }
}