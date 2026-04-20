/*3b(Q2). Write a Java Program for Counting how many times a substring appears in a main string
using user defined function countOccurrences()*/

package String_Functions;
import java.util.Scanner;

public class SubstringCount {

    // User-defined function to count occurrences of substring
    public static int countOccurrences(String mainString, String subString) {
        if (mainString == null || subString == null || subString.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index = index + subString.length(); // move past last found substring
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter main string: ");
        String mainString = sc.nextLine();

        System.out.print("Enter substring: ");
        String subString = sc.nextLine();

        int result = countOccurrences(mainString, subString);

        System.out.println("Number of occurrences: " + result);

        sc.close();
    }
}
