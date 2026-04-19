/*Q6. Write a Java Program for Capitalizing the first letter of each word. using user defined function
capitalizeWords()*/

package String_Functions;

import java.util.Scanner;

public class CapitalizeWords {

	    // User-defined function
	    public static String capitalizeWords(String str) {

	        if (str == null || str.trim().isEmpty()) {
	            return str;
	        }

	        String[] words = str.trim().split("\\s+");
	        StringBuilder result = new StringBuilder();

	        for (String word : words) {
	            if (word.length() > 0) {
	                // Capitalize first letter, keep rest same
	                result.append(Character.toUpperCase(word.charAt(0)))
	                      .append(word.substring(1))
	                      .append(" ");
	            }
	        }

	        return result.toString().trim();
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a sentence: ");
	        String input = sc.nextLine();

	        String output = capitalizeWords(input);

	        System.out.println("Capitalized String: " + output);

	        sc.close();
	    }
	}