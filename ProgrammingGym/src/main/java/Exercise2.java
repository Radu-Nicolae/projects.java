import java.util.*;

public class Exercise2 { //Interclasare1

    // There are two strings a and b, with n and m, respectively, elements, natural numbers, ordered
    // strictly in ascending order. Display, in strictly ascending order, the values existing in at least
    // one of the two strings. If a value appears in both strings, it will be displayed only once.

    // The input string contains the number n; followed by natural numbers, in strictly
    // ascending order, which can be arranged on several lines. The next line contains the number m and follows m natural
    // numbers, in strict ascending order, which can be arranged on several lines.

    // example
    // input: 7
    // 1 3 4
    // 7 20 24 60
    // 9
    // 3 5 7
    // 8 9 10 12
    // 20 24

    //output
    //1 3 4 5 7 8 9 10 12 20
    //24 60

    // The output string will contain, in ascending order, the values in at least one of the two strings. These values
    // will be displayed 10 on a line, separated by spaces. The last line can contain less than 10 values.

    public static void exercise2main() {
        // TODO:
        // -> get the two lists of numbers
        // -> make an empty set
        // -> insert in the set both the arrays of number
        // -> in the end, print the set and when the index of for is i % 10 == 9, make a free space

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
        List<Integer> returnedArray = getTheIndexAndTheCounter(input, number, counter, index);
        index = returnedArray.get(0);
        counter = returnedArray.get(1);
        counter += 1;


        // getting the elements from the first array
        List<List<Integer>> returnedArrayBig;
        returnedArrayBig = getElements(list1, index, counter, input);
        list1 = returnedArrayBig.get(0);
        counter = returnedArrayBig.get(1).get(0);


        // getting the 1st number from the 2nd list (number, not digit)
        number = "";
        returnedArray = getTheIndexAndTheCounter(input, number, counter, index);
        index += returnedArray.get(0);
        counter = returnedArray.get(1);
        counter++;


        // getting the elements from the first array
        list2 = getElements(list2, index, counter, input).get(0);


        whyPrintingLikeThis(reunionOfTheNumbers(list1, list2));
    }


    public static List<Integer> getTheIndexAndTheCounter(String input, String number, int counter, int index) {
        // getting the 1st number from the list (number, not digit)
        while (input.charAt(counter) != ' ') {
            if (input.charAt(counter) > 47 && input.charAt(counter) < 58) { // <3 ascii (searching only for digits)
                number += input.charAt(counter);
            } else break;
            counter++;
        }
        index = Integer.parseInt(number);

        List<Integer> toBeReturned = new ArrayList<>(); // made like this to return multiple variables
        toBeReturned.add(index);
        toBeReturned.add(counter);

        return toBeReturned;
    }


    public static List<List<Integer>> getElements(List<Integer> list, int index, int counter, String input) {
        while (list.size() < index) {
            String number = "";
            while (input.charAt(counter) != ' ') {
                if (input.charAt(counter) > 47 && input.charAt(counter) < 58) { // <3 ascii (searching only for digits)
                    number += input.charAt(counter);
                } else break;
                counter++;
                if (counter >= input.length()) break;
            }

            list.add(Integer.parseInt(number)); // converting string to int
            counter++;
            if (counter >= input.length()) break;
        }
        List<List<Integer>> toBeReturned = new ArrayList<>();

        List<Integer> tbr1 = new ArrayList<>(); // made like this to return multiple variables
        tbr1.add(counter);

        toBeReturned.add(list); //first product is the big list
        toBeReturned.add(tbr1); //second product is the counter

        return toBeReturned;
    }


    public static Set<Integer> reunionOfTheNumbers(List<Integer> list1, List<Integer> list2) {
        Set<Integer> numbers = new TreeSet<>();

        for (int i = 0; i < list1.size(); i++) {
            numbers.add(list1.get(i));
        }

        for (int i = 0; i < list1.size(); i++) {
            numbers.add(list2.get(i));
        }

        return numbers;
    }


    public static void whyPrintingLikeThis(Set<Integer> numbers) {
        List<Integer> numbersList = new ArrayList<>(numbers); //converting set to list in order to access elements

        for (int i = 0; i < numbersList.size(); i++) {
            if (i % 10 == 9) {
                System.out.println(numbersList.get(i));
            } else System.out.print(numbersList.get(i) + " ");

        }

    }

}
