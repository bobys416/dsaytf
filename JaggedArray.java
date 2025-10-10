public class JaggedArray {
    public static void main(String[] args) {
        
        int Array[][] = {
            {1, 2, 3},
            {1, 3, 4, 5, 6},
            {1, 6, 7, 8, 9, 4}
        };

        int i = 0; 
        while (i < Array.length) {
            int j = 0; 

            
            while (j < Array[i].length) {
                System.out.print(Array[i][j] + " ");
                j++;
            }

            System.out.println(); 
            i++;
        }
    }
}