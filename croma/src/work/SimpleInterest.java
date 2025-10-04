package work;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Principal amount (P): ");
        double principal = scanner.nextDouble();
        
        System.out.print("Enter Time period in years (T): ");
        double time = scanner.nextDouble();
        
        System.out.print("Enter Rate of interest (R): ");
        double rate = scanner.nextDouble();
        
        // Calculate Simple Interest using formula: SI = (P x T x R)/100
        double simpleInterest = (principal * time * rate) / 100;
        
        // Calculate total amount
        double totalAmount = principal + simpleInterest;
        
        System.out.println("\nSimple Interest Calculation:");
        System.out.println("Principal (P): " + principal);
        System.out.println("Time (T): " + time + " years");
        System.out.println("Rate (R): " + rate + "%");
        System.out.println("Simple Interest: " + simpleInterest);
        System.out.println("Total Amount: " + totalAmount);
        
        scanner.close();
    }
}
