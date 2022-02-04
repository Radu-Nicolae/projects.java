import java.util.Scanner;

public class Utilities {

    static Scanner scn;
    public static int getValidInteger() {
        String answer;
        int asnwerInt = 0;
        scn = new Scanner(System.in);

        try {
            answer = scn.next();
            asnwerInt = Integer.parseInt(answer);
        } catch (NumberFormatException exception) {
            System.out.print("Please enter a valid input: ");
            asnwerInt = getValidInteger();
        }

        return asnwerInt;
    }


    public static int[][] getMatrix() {
        scn = new Scanner(System.in);

        System.out.println("How many rows and columns will the matrix have?");
        System.out.print("Your answer: ");

        int rowsAndColumns = 0;
        rowsAndColumns = scn.nextInt();

        int elements[][] = new int[rowsAndColumns][rowsAndColumns];

        System.out.println("\n\nThe matrix will be displayed as following: ");
        System.out.println("a11  a12  a13  ...  a1n");
        System.out.println("a21  a22  a23  ...  a2n");
        System.out.println("a31  a31  a33  ...  a3n");
        System.out.println("...  ...  ...  ...  ...");
        System.out.println("an1  an2  an3  ...  ann");
        System.out.println("\n\n");

        int answer;

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                System.out.print("Enter a" + i + j + ": ");
                answer = scn.nextInt();
                elements[i][j] = answer;
            }
        }

        return elements;
    }
}
