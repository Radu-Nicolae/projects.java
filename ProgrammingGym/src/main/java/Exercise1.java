import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise1 {

    public static void exercise1main() { //intersectie_siruri
        // Giving several ascending strings of natural numbers, the end of each such string
        // being marked with the number 0, it is required to display in strictly ascending order, the numbers common to all strings.

        // This exercise could be done much easier but the task was to finish it using sets.


        //TODO
        //we have zero counter so that we'll know how many sets we'll have - done
        //we have the large set, containing all the elements - done
        //for each set take out of the large set the numbers that are not contained by the set
        //for instance if we have A = {1, 3, 5} and large = {1, 3, 4, 5} we take 4 out from the large set
        //in the end we print the large set

        String initialArray = "1 2 3 7 10 0 1 4 5 7 10 0 2 3 7 10 0 2 3 5 7 9 10 0";
        Set<Integer> allNumbersSet = new HashSet<>();
        List<Integer> allNumbersArray = new ArrayList<>();
        String numberString = new String("");
        int number;
        int zeroCounter = 0;

        for (int i = 0; i < initialArray.length(); i++) {
            if (initialArray.charAt(i) != ' ') {
                numberString += initialArray.charAt(i); // add numbers to tthe string
            } else {
                number = Integer.parseInt(numberString);

                if (number == 0) {
                    zeroCounter++;
                }

                allNumbersArray.add(number);
                numberString = "";
            }
        }

        //now all elements are stored in allNumbers

        for (int i = 0; i < allNumbersArray.size(); i++) {
            allNumbersSet.add(allNumbersArray.get(i));
        }


        int currentNumber = 0;
        int oldJ = 0;

        Set<Integer> toBePrinted = new HashSet<>();
        for (int i = 0; i < zeroCounter + 1; i++) {
            List<Integer> tempSet = new ArrayList<>();
            for (int j = oldJ; j < allNumbersArray.size(); j++) {
                if (allNumbersArray.get(j) != 0) {
                    tempSet.add(allNumbersArray.get(j));
                } else {
                    oldJ = j + 1;
                    break;
                }
            }

            //in java you cannot take an element from set so you'll need to convert it to array
            List<Integer> setConverted = new ArrayList<>();
            for (Integer t : allNumbersSet)
                setConverted.add(t);


            for (int j = 0; j < allNumbersSet.size(); j++) {
                if (!tempSet.contains(setConverted.get(j))) {
                    toBePrinted.add(setConverted.get(j));
                }
            }

        }

        for (int i = 0; i < allNumbersArray.size() / zeroCounter; i++) {
            if (!toBePrinted.contains(allNumbersArray.get(i))) {
                System.out.println(allNumbersArray.get(i));
            }
        }
    }

}
