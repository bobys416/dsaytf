package work;
import java.util.Scanner;

public class ArmstrongNumberChecker {
    
    // Method to check if a number is Armstrong
    public static int isArmstrong(int number) {
        int originalNumber = number;
        int digits = 0;
        int sum = 0;
        
        // Count number of digits
        while (originalNumber != 0) {
            originalNumber /= 10;
            digits++;
        }
        
        originalNumber = number;
        
        // Calculate sum of digits raised to the power of number of digits
        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum += Math.pow(digit, digits);
            originalNumber /= 10;
        }
        
        // Return 1 if Armstrong, 2 if not Armstrong
        return (sum == number) ? 1 : 2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int result = isArmstrong(number);
        
        if (result == 1) {
            System.out.println("1 - " + number + " is an Armstrong number.");
        } else {
            System.out.println("2 - " + number + " is not an Armstrong number.");
        }
        
        scanner.close();
    }
}
