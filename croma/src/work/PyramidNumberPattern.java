package work;

import java.util.Scanner;

public class PyramidNumberPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rows (r): ");
        int r = scanner.nextInt();
        
        System.out.println("\nPyramid Number Pattern:");
        
        // Print pyramid number pattern
        for (int i = 1; i <= r; i++) {
            // Print spaces
            for (int j = 1; j <= r - i; j++) {
                System.out.print("  ");
            }
            
            // Print increasing numbers
            for (int k = i; k <= 2 * i - 1; k++) {
                System.out.print(k + " ");
            }
            
            // Print decreasing numbers
            for (int l = 2 * i - 2; l >= i; l--) {
                System.out.print(l + " ");
            }
            
            System.out.println(); // Move to next line
        }
        
        scanner.close();
    }
}
