package croma;

import java.util.Scanner;

public class Scanner1 {
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name:- ");
		String name = obj.nextLine();

		
		System.out.println("Enter your age:- ");
		int age = sc.nextInt();

		System.out.println("Enter your address:- ");
		String address = obj.nextLine();
        
		System.out.println("Enter your Height:- ");
		// int height = obj.nextInt();
        float height=sc.nextFloat();
		System.out.println("Enter your Weight:- ");
	    //int weight = obj.nextInt();
		float weight=sc.nextFloat();

		System.out.println("Name: " + name);
		System.out.println("Your Age: " + age);
		System.out.println("Your Address: " + address);
		System.out.println("Your Height: " + height + "cm");
		System.out.println("Your Weight: " + weight + "kg");

	}

}
