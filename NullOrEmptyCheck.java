/*Q1. Write a Java Program for Checking if a given string is null or contains only whitespace using user
defined function isNullOrEmpty().*/
package String_Functions;
import java.util.Scanner;

public class NullOrEmptyCheck{

    // User-defined function
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isNullOrEmpty(input)) {
            System.out.println("The string is NULL or EMPTY (only whitespace).");
        } else {
            System.out.println("The string is NOT empty: " + input);
        }

        sc.close();
    }
}
