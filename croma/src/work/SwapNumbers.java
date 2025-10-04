package work;

import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter value for m: ");
        int m = scanner.nextInt();
        
        System.out.print("Enter value for n: ");
        int n = scanner.nextInt();
        
        System.out.println("\nBefore swapping:");
        System.out.println("m = " + m + ", n = " + n);
        
        // Swap the numbers using a temporary variable
        int temp = m;
        m = n;
        n = temp;
        
        System.out.println("\nAfter swapping:");
        System.out.println("m = " + m + ", n = " + n);
        
        scanner.close();
    }
}
