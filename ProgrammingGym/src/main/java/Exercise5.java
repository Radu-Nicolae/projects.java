import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise5 {

// Give a matrix with n lines and n columns and elements natural numbers. Calculate the absolute
// difference between the sums of the elements on the two diagonals.

//        4
//        8 3 3 7
//        1 1 6 5
//        8 7 1 1
//        9 8 7 1

//        OUTPUT: 18

    static Scanner scn;

    public static void exercise5main() {
        int elements[][] = Utilities.getMatrix();

        System.out.println("\n\nThe absolute difference is: " + Math.abs(diagonal1Sum(elements, elements.length) - diagonalSum2(elements, elements.length)));

    }

    public static int diagonal1Sum(int[][] elements, int rowsAndColumns) {
        int sum = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            sum += elements[i][i];
        }

        return sum;
    }

    public static int diagonalSum2(int[][] elements, int rowsAndColumns) {
        int sum = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            sum += elements[i][rowsAndColumns - 1 - i];
        }

        return sum;
    }
}
