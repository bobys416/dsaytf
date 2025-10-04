package work;

import java.util.Scanner;

public class PerfectSquareChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        boolean isPerfectSquare = false;
        int squareRoot = 0;
        
        // Check if number is a perfect square
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                isPerfectSquare = true;
                squareRoot = i;
                break;
            }
        }
        
        if (isPerfectSquare) {
            System.out.println(number + " is a perfect square.");
            System.out.println("Square root: " + squareRoot);
            System.out.println("Verification: " + squareRoot + " * " + squareRoot + " = " + (squareRoot * squareRoot));
        } else {
            System.out.println(number + " is not a perfect square.");
        }
        
        scanner.close();
    }
}
