package work;

import java.util.Scanner;

public class MirrorUpperStarTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size: ");
        int size = scanner.nextInt();
        
        System.out.println("\nMirror Upper Star Triangle Pattern:");
        
        // Upper triangle
        for (int i = 1; i <= size; i++) {
            // Print spaces
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println(); // Move to next line
        }
        
        // Lower triangle (mirror)
        for (int i = size; i >= 1; i--) {
            // Print spaces
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
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
