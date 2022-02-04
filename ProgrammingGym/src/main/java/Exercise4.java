import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.*;

public class Exercise4 { //IRDDS

// Given 2 sets of natural numbers A and B. Display the set resulting from performing an operation.
// The program reads from the keyboard:
//
// On the first line 2 natural numbers N and M, representing the number of elements of the set A, respectively B, followed by one of the characters * + -%:
// * intersection A∩B.
// + A∪B meeting.
// - difference A ∖ B.
// % symmetric difference (A ∖ B) ∪ (B ∖ A).
// On the 2nd line N natural numbers representing the elements of the set A.
// On the 3rd line M natural numbers representing the elements of the set B.

    static Scanner scn = new Scanner(System.in);

    public static void exercise4main() {
        System.out.println("Exercise 4");
        System.out.print("Enter number of the elements from the first set: ");
        int noOfElements1 = getValidInteger();
        System.out.print("Enter number of the elements from the second set: ");
        int noOfElements2 = getValidInteger();

        System.out.print("Choose a sign\n\" * \" - for intersection\n\" + \" - for reunion\n" +
                "\" - \" - for difference\n\" % \" - for simetric difference (A∖B)∪(B∖A)\nYour answer: ");

        String sign = scn.next(); //using a string, not a char, since multiple characters stored in a char would break the whole code

        List<Integer> list1 = getTheArray(noOfElements1);
        List<Integer> list2 = getTheArray(noOfElements2);

        switch (sign) {
            case "*":
                System.out.println("\n\nThe intersection is: " + getTheIntersection(list1, list2));
            case "+":
                Set<Integer> reunion = new HashSet<>(list1);
                reunion.addAll(list2);
                System.out.println("\n\nThe reunion is: " + reunion);
            case "-":
                System.out.println("\n\nThe difference A\\B is: " + getTheDifference(list1, list2));
            case "%":
                reunion = getTheDifference(list1, list2);
                reunion.addAll(getTheDifference(list2, list1));
                System.out.println("\n\nThe simetric difference is: " + reunion);
            default:
                System.out.println("\n\nInvalid input sign! Please select one of those for chars.\nDon't try to crash this code, you won't :).");

        }


    }

    public static Set<Integer> getTheDifference(List<Integer> list1, List<Integer> list2){
        Set<Integer> allValues = new HashSet<>(); //don't want duplicates, we have xerox for that

        for (Integer integer : list1) {
            if (!list2.contains(integer)) {
                allValues.add(integer);
            }
        }

        return allValues;
    }


    public static List<Integer> getTheIntersection(List<Integer> list1, List<Integer> list2){
       Set<Integer> intersection = new HashSet<>();
        for (int i = 0; i < list1.size(); i++) {
            if (list2.contains(list1.get(i))){
                intersection.add(list1.get(i));
            }
        }

        return new ArrayList<>(intersection);
    }

    public static List<Integer> getTheArray(int noOfElements) {
        List<Integer> array = new ArrayList<>();
        String input = "";

        System.out.println("");
        for (int i = 0; i < noOfElements; i++) {
            System.out.print("Enter the element number " + (i + 1) + ": ");
            array.add(getValidInteger());
        }

        return array;
    }


    public static int getValidInteger() {
        String answer = "";
        int asnwerInt = 0;

        try {
            answer = scn.next();
            asnwerInt = Integer.parseInt(answer);
        } catch (NumberFormatException exception) {
            System.out.print("Please enter a valid input: ");
            asnwerInt = getValidInteger();
        }

        return asnwerInt;
    }


}
