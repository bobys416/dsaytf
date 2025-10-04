package work;

import java.util.Scanner;

public class VowelConsonant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);
        
        // Convert to lowercase for easier comparison
        ch = Character.toLowerCase(ch);
        
        // Check if character is a vowel
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            System.out.println("'" + ch + "' is a vowel.");
        } else if (ch >= 'a' && ch <= 'z') {
            System.out.println("'" + ch + "' is a consonant.");
        } else {
            System.out.println("'" + ch + "' is not a valid alphabet character.");
        }
        
        scanner.close();
    }
}
