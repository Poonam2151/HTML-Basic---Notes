import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Read the number of matrices
        int N = Integer.parseInt(scanner.nextLine().trim());
        
        // Step 2: Read the dimensions of the matrices
        String[] dimensions = scanner.nextLine().trim().split(" ");
        int r = Integer.parseInt(dimensions[0]);
        int c = Integer.parseInt(dimensions[1]);
        
        // Step 3: Read the matrices
        List<List<int[]>> matrices = new ArrayList<>();
        
        // Initialize matrices
        for (int i = 0; i < N; i++) {
            matrices.add(new ArrayList<>());
        }
        
        // Read r lines of matrix data
        for (int i = 0; i < r; i++) {
            String[] numbers = scanner.nextLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                int[] matrixRow = new int[c];
                for (int k = 0; k < c; k++) {
                    matrixRow[k] = Integer.parseInt(numbers[j * c + k]);
                }
                matrices.get(j).add(matrixRow);
            }
        }
        
        // Step 4: Read the instructions and process them
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue; // Skip empty lines
            
            String[] indices = line.split(" ");
            for (String index : indices) {
                int matrixIndex = Integer.parseInt(index) - 1; // Convert to 0-based index
                List<int[]> matrix = matrices.get(matrixIndex);
                
                // Print the matrix
                for (int[] row : matrix) {
                    for (int num : row) {
                        System.out.print(num + " ");
                    }
                }
                System.out.println(); // New line after each matrix
            }
        }
        
        scanner.close();
    }
}