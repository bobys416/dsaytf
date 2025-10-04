package croma;

public class pattern {
	 
	    // 1. Square Pattern
	    public static void squarePattern(int n) {
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                System.out.print("* ");
	            }
	            System.out.println();
	        }
	    }

	    // 2. Right Triangle Pattern
	    public static void rightTriangle(int n) {
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= i; j++) {
	                System.out.print("* ");
	            }
	            System.out.println();
	        }
	    }

	    // 3. Left Triangle Pattern
	    public static void leftTriangle(int n) {
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n - i; j++) {
	                System.out.print("  ");
	            }
	            for (int k = 1; k <= i; k++) {
	                System.out.print("* ");
	            }
	            System.out.println();
	        }
	    }

	    // 4. Pyramid Pattern
	    public static void pyramidPattern(int n) {
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n - i; j++) {
	                System.out.print(" ");
	            }
	            for (int k = 1; k <= 2 * i - 1; k++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	    }

	    // 5. Diamond Pattern
	    public static void diamondPattern(int n) {
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n - i; j++) {
	                System.out.print(" ");
	            }
	            for (int k = 1; k <= 2 * i - 1; k++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	        for (int i = n - 1; i >= 1; i--) {
	            for (int j = 1; j <= n - i; j++) {
	                System.out.print(" ");
	            }
	            for (int k = 1; k <= 2 * i - 1; k++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	    }

	    // 6. Numeric Square Pattern
	    public static void numericSquare(int n) {
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n; j++) {
	                System.out.print(j + " ");
	            }
	            System.out.println();
	        }
	    }

	    // 7. Numeric Right Triangle
	    public static void numericRightTriangle(int n) {
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= i; j++) {
	                System.out.print(j + " ");
	            }
	            System.out.println();
	        }
	    }

	    // 8. Floyd's Triangle
	    public static void floydsTriangle(int n) {
	        int num = 1;
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= i; j++) {
	                System.out.print(num++ + " ");
	            }
	            System.out.println();
	        }
	    }

	    // 9. Numeric Pyramid (centered, increasing numbers)
	    public static void numericPyramid(int n) {
	        for (int i = 1; i <= n; i++) {
	            for (int s = 1; s <= n - i; s++) {
	                System.out.print("  ");
	            }
	            for (int j = 1; j <= i; j++) {
	                System.out.print(j + " ");
	            }
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        int n = 5;
	        System.out.println("Square Pattern:");
	        squarePattern(n);

	        System.out.println("\nRight Triangle Pattern:");
	        rightTriangle(n);

	        System.out.println("\nLeft Triangle Pattern:");
	        leftTriangle(n);

	        System.out.println("\nPyramid Pattern:");
	        pyramidPattern(n);

	        System.out.println("\nDiamond Pattern:");
	        diamondPattern(n);

	        // Numeric patterns
	        System.out.println("\nNumeric Square Pattern:");
	        numericSquare(n);

	        System.out.println("\nNumeric Right Triangle:");
	        numericRightTriangle(n);

	        System.out.println("\nFloyd's Triangle:");
	        floydsTriangle(n);

	        System.out.println("\nNumeric Pyramid:");
	        numericPyramid(n);
	    }
	}

