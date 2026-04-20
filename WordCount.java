/*3c(Q10). Write a Java Program for Counting the number of words in a string using user defined function
countWords()*/

package String_Functions;

import java.util.Scanner;

public class WordCount {

    // User-defined function to count words
    public static int countWords(String str) {

        if (str == null || str.trim().isEmpty()) {
            return 0;
        }

        // Split string based on one or more spaces
        String[] words = str.trim().split("\\s+");

        return words.length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Call function
        int count = countWords(input);

        // Output result
        System.out.println("Number of words: " + count);

        sc.close();
    }
}
