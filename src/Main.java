import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;
    public static final int MAX_NUMBER = 256;
    public static void main(String[] args) {
        int [][] originalMatrix = createMatrix(SIZE);

        System.out.println("\nОригинальная матрица:");
        printMatrix(originalMatrix);

        System.out.println("\nВыбери угол поворота: 90, 180, 270");
        Scanner scanner = new Scanner(System.in);
        int angle = scanner.nextInt();
        int[][] rotatedMatrix = rotateMatrix(originalMatrix,angle);

        System.out.println("\nПеревернутая матрица:");
        printMatrix(rotatedMatrix);
    }
    public static int[][] rotateMatrix(int[][] originalMatrix, int angle){
        int size = originalMatrix.length;
        int[][] result = new int [size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (angle){
                    case 90:
                        result[i][j] = originalMatrix[size - 1 - j][i];
                        break;
                    case 180:
                        result[i][j] = originalMatrix[size - i - 1][size - 1 - j];
                        break;
                    case 270:
                        result[size - 1 - j][i] = originalMatrix[i][j];
                        break;
                    default:
                        result[i][j] = originalMatrix[i][j];
                        break;
                }
            }
        }
        return result;
    }
    public static int[][] rotateMatrix(int[][] originalMatrix){
        int size = originalMatrix.length;
        int[][] result = new int [size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = originalMatrix[size - 1 - j][i];
            }
        }
        return result;
    }

    public static int [][] createMatrix(int size) {
        Random random = new Random();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(MAX_NUMBER);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
