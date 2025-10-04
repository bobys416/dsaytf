package croma;
import java.util.Scanner;
public class operatoroperations {
	
	public static void bitwiseOperations(int a, int b) {
        System.out.println("\n--- Bitwise Operations ---");
        System.out.println(a + " & " + b + " = " + (a & b) + "   (Bitwise AND)");
        System.out.println(a + " | " + b + " = " + (a | b) + "   (Bitwise OR)");
        System.out.println(a + " ^ " + b + " = " + (a ^ b) + "   (Bitwise XOR)");
        System.out.println("~" + a + " = " + (~a) + "         (Bitwise NOT of a)");
        System.out.println("~" + b + " = " + (~b) + "         (Bitwise NOT of b)");
        System.out.println(a + " << 1 = " + (a << 1) + "   (Left Shift a by 1)");
        System.out.println(b + " >> 1 = " + (b >> 1) + "   (Right Shift b by 1)");
    }
	
	public static void logicalOperations(int a, int b) {
        System.out.println("\n--- Logical Operations ---");
        System.out.println("(" + a + " > 0) && (" + b + " > 0) = " + (a > 0 && b > 0) + "   (Logical AND)");
        System.out.println("(" + a + " > 0) || (" + b + " > 0) = " + (a > 0 || b > 0) + "   (Logical OR)");
        System.out.println("!(" + a + " > 0) = " + (!(a > 0)) + "   (Logical NOT)");
    }
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bitwise and Logical Operator Project ===");
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // Perform operations without loop
        bitwiseOperations(a, b);
        logicalOperations(a, b);

        sc.close();
    }
}
