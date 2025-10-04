package work;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input a number: ");
        int number = scanner.nextInt();
        
        System.out.println("\nMultiplication table for " + number + ":");
        
        // Print multiplication table up to 10
        for (int i = 1; i <= 10; i++) {
            int result = number * i;
            System.out.println(number + " x " + i + " = " + result);
        }
        
        scanner.close();
    }
}
