package work;

import java.util.Scanner;

public class PrimeNumberChecker {
    
    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        
        // Check for divisibility from 2 to sqrt(number)
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        boolean result = isPrime(number);
        
        if (result) {
            System.out.println("true - " + number + " is a prime number.");
        } else {
            System.out.println("false - " + number + " is not a prime number.");
        }
        
        scanner.close();
    }
}
