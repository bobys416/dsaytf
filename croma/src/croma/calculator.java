package croma;
import java.util.Scanner;

public class calculator {

	public static void main(String[] args) {
		Scanner cu = new Scanner(System.in);
		Scanner fu = new Scanner(System.in);
        System.out.println("Enter your first value: ");
        int a=cu.nextInt();
        System.out.println("Enter your second value: ");
        int b=cu.nextInt();
        
        System.out.println("What you want to calculate? Enter 1 for add, 2 for sub, 3 for mul, 4 for divide, 5 for mod: ");
        int value = fu.nextInt();

        if (value == 1) {
            System.out.println("Result: " + (a + b));
        } else if (value == 2) {
            System.out.println("Result: " + (a - b));
        } else if (value == 3) {
            System.out.println("Result: " + (a * b));
        } else if (value == 4) {
            if (b != 0) {
                System.out.println("Result: " + (a / b));
            } else {
                System.out.println("Cannot divide by zero.");
            }
        } else if (value == 5) {
            if (b != 0) {
                System.out.println("Result: " + (a % b));
            } else {
                System.out.println("Cannot mod by zero.");
            }
        } else {
            System.out.println("Invalid operation.");
        }
        fu.close();
        cu.close();
    }       
        
}

