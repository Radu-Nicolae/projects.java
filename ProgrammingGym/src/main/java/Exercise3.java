import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Exercise3 { //Interclasare2

    // There are two strings a and b, with n and m, respectively, elements, natural numbers, ordered
    // strictly in ascending order. Display, in strictly ascending order, the values existing in at least
    // one of the two strings. If a value appears in both strings, it will be displayed only once.

    // The input string contains the number n; followed by natural numbers, in strictly
    // ascending order, which can be arranged on several lines. The next line contains the number m and follows m natural
    // numbers, in strict ascending order, which can be arranged on several lines.

    // The string will contain, in ascending order, the values in both strings. These values will be
    // displayed 10 on a line, separated by spaces. The last line can contain less than 10 values.

    // example
    // input: 7
    // 1 3 4
    // 7 20 24 60
    // 9
    // 3 5 7
    // 8 9 10 12
    // 20 24

    //output
    //3 7 20 24

    public static void exercise3main() {
        // TODO:
        // -> get the two lists of numbers (same as ex 2)
        // -> make an empty set (same as ex 2)
        //

        String input = "7\n" +
                "1 3 4\n" +
                "7 20 24 60\n" +
                "9\n" +
                "3 5 7\n" +
                "8 9 10 12\n" +
                "20 24";

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int index = 0;
        int counter = 0;
        String number = "";

        // getting the 1st number from the list (number, not digit)
        List<Integer> returnedArray = Exercise2.getTheIndexAndTheCounter(input, number, counter, index);
        index = returnedArray.get(0);
        counter = returnedArray.get(1);
        counter += 1;


        // getting the elements from the first array
        List<List<Integer>> returnedArrayBig;
        returnedArrayBig = Exercise2.getElements(list1, index, counter, input);
        list1 = returnedArrayBig.get(0);
        counter = returnedArrayBig.get(1).get(0);


        // getting the 1st number from the 2nd list (number, not digit)
        number = "";
        returnedArray = Exercise2.getTheIndexAndTheCounter(input, number, counter, index);
        index += returnedArray.get(0);
        counter = returnedArray.get(1);
        counter++;

        // getting the elements from the first array
        list2 = Exercise2.getElements(list2, index, counter, input).get(0);

        Exercise2.whyPrintingLikeThis(getIntersection(list1, list2));

    }

    public static Set<Integer> getIntersection(List<Integer> list1, List<Integer> list2){
        Set<Integer> numbers = new TreeSet<>();
        for (int i = 0; i < list1.size(); i++) {
            if (list2.contains(list1.get(i))){
                numbers.add(list1.get(i));
            }
        }

        return numbers;
    }
}
