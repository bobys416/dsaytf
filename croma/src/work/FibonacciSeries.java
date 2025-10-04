package work;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of terms in Fibonacci series: ");
        int n = scanner.nextInt();
        
        System.out.println("\nFibonacci Series:");
        
        int first = 0, second = 1;
        
        if (n >= 1) {
            System.out.print(first);
        }
        if (n >= 2) {
            System.out.print(", " + second);
        }
        
        // Generate remaining terms
        for (int i = 3; i <= n; i++) {
            int next = first + second;
            System.out.print(", " + next);
            first = second;
            second = next;
        }
        
        System.out.println(); // Move to next line
        
        scanner.close();
    }
}
