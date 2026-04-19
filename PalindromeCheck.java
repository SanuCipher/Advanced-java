/*Q4. Write a Java Program for Checking if a string reads the same backward as forward (ignoring case
and punctuation) using user defined function isPalindrome()*/

package String_Functions;

import java.util.Scanner;

public class PalindromeCheck {

    // User-defined function to check palindrome
    public static boolean isPalindrome(String str) {

        if (str == null) {
            return false;
        }

        // Step 1: Remove all non-alphanumeric characters (punctuation, spaces, etc.)
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "");

        // Step 2: Convert to lowercase (ignore case)
        cleaned = cleaned.toLowerCase();

        // Step 3: Reverse the cleaned string
        String reversed = "";

        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed = reversed + cleaned.charAt(i);
        }

        // Step 4: Compare original cleaned string with reversed string
        return cleaned.equals(reversed);
    }

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Input string from user
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Call user-defined function
        if (isPalindrome(input)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        // Close scanner
        sc.close();
    }
}


