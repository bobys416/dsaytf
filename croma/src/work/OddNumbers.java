package work;

public class OddNumbers {
    public static void main(String[] args) {
        System.out.println("Odd numbers from 1 to 50:");
        
        // Print odd numbers from 1 to 50
        for (int i = 1; i <= 50; i += 2) {
            System.out.print(i);
            if (i < 49) {
                System.out.print(", ");
            }
        }
        
        System.out.println(); // Move to next line
    }
}
