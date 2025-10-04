package work;

import java.util.Scanner;

public class InvertedRightTrianglePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rows (n): ");
        int n = scanner.nextInt();
        
        System.out.println("\nInverted Right Triangle Pattern:");
        
        // Print inverted right triangle pattern
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // Print asterisks
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println(); // Move to next line
        }
        
        scanner.close();
    }
}
