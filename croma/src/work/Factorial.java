package work;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to calculate factorial: ");
        int n = scanner.nextInt();
        
        long factorial = 1;
        
        // Calculate factorial using for loop
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        
        System.out.println("Factorial of " + n + " is: " + factorial);
        
        scanner.close();
    }
}
