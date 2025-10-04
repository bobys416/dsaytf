package work;

import java.util.Scanner;

public class RightTrianglePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rows (n): ");
        int n = scanner.nextInt();
        
        System.out.println("\nRight Triangle Pattern:");
        
        // Print right triangle pattern
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println(); // Move to next line
        }
        
        scanner.close();
    }
}
