import java.util.*;

public class Exercise8 {

//    3
//            9
//            5 10 -5 8 -2 -7 0 -9 10
//            7
//            -6 -5 -4 0 2 5 8
//            5
//            2 7 8 10 10
    
    static Scanner scn = new Scanner(System.in);
    public static void exercise8main(){
        System.out.print("How many arrays will you enter? Your answer: ");
        int numberOfArrays = scn.nextInt();
        int numberOfElements;

        List<List<Integer>> allArrays = new ArrayList<>();
        for (int i = 0; i < numberOfArrays; i++) {
            System.out.print("Enter the number of elements from array number " + (i + 1) + ": ");
            numberOfElements = scn.nextInt();
            List<Integer> array = new ArrayList<>();

            for (int j = 0; j < numberOfElements; j++) {
                array.add(scn.nextInt());
            }

            allArrays.add(array);
        }

        //printing everything
//        for (int i = 0; i < allArrays.size(); i++) {
//            for (int j = 0; j < allArrays.get(i).size(); j++) {
//                System.out.print(allArrays.get(i).get(j) + " ");
//            }
//            System.out.println("");
//        }

        for (int i = 0; i < allArrays.size(); i++) {
            List<Integer> currentArray = allArrays.get(i);
            List<Integer> sortedArray = currentArray;

            Collections.sort(sortedArray);
            System.out.println(sortedArray);
            boolean isItOk = true;
            for (int j = 0; j < currentArray.size(); j++) {
                if (currentArray.get(j) != sortedArray.get(j)){
                    isItOk = false;
                    break;
                }
            }

            System.out.println(isItOk);
        }
        
    }
}
