/*Q9. Write a Java Program for Creating a random string of a specified length using user defined
function generateRandomString()*/

package String_Functions;

import java.util.Random;
import java.util.Scanner;

public class RandomStringGenerator {

    public static String generateRandomString(int length) {

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        String result = "";

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result = result + characters.charAt(index);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of random string: ");

        // Check if input is integer
        if (sc.hasNextInt()) {
            int len = sc.nextInt();

            String randomString = generateRandomString(len);
            System.out.println("Random String: " + randomString);

        } else {
            System.out.println("Invalid input! Please enter a number only.");
        }

        sc.close();
    }
}