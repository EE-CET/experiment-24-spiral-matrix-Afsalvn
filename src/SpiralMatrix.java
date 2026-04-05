
import java.util.Scanner;

public class SpiralMatrix {

    // Task: Traverse an r x c matrix in spiral form
    public void printSpiral(int[][] matrix, int r, int c) {
        // Define our four boundaries
        int top = 0;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;
        
        boolean isFirstElement = true;

        // Keep peeling layers as long as the boundaries haven't crossed
        while (top <= bottom && left <= right) {
            
            // 1. Traverse the Top Row (Left to Right)
            for (int i = left; i <= right; i++) {
                if (!isFirstElement) System.out.print(" ");
                System.out.print(matrix[top][i]);
                isFirstElement = false;
            }
            top++; // Shrink the top boundary downward

            // 2. Traverse the Right Column (Top to Bottom)
            for (int i = top; i <= bottom; i++) {
                if (!isFirstElement) System.out.print(" ");
                System.out.print(matrix[i][right]);
                isFirstElement = false;
            }
            right--; // Shrink the right boundary inward

            // 3. Traverse the Bottom Row (Right to Left)
            // We must check if the top and bottom boundaries crossed to avoid printing duplicates
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    if (!isFirstElement) System.out.print(" ");
                    System.out.print(matrix[bottom][i]);
                    isFirstElement = false;
                }
                bottom--; // Shrink the bottom boundary upward
            }

            // 4. Traverse the Left Column (Bottom to Top)
            // We must check if the left and right boundaries crossed
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if (!isFirstElement) System.out.print(" ");
                    System.out.print(matrix[i][left]);
                    isFirstElement = false;
                }
                left++; // Shrink the left boundary inward
            }
        }
        System.out.println(); // Final newline for clean output
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read matrix dimensions r and c
        if (sc.hasNextInt()) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int[][] matrix = new int[r][c];
            
            // Read matrix elements
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            SpiralMatrix solver = new SpiralMatrix();
            // Print the spiral traversal
            solver.printSpiral(matrix, r, c);
        }
        
        sc.close();
    }
}
