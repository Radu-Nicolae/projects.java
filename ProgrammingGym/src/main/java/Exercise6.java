public class Exercise6 {

//    Write a java function that has 3 parameters: one, which receives a one-dimensional array // one with the length is useless
//    with a maximum of 100 natural numbers less than 1000, another, the actual number of array elements, and a natural number.
//
//    The function returns the number of elements in the array that are multiples of the number k and have the last digit equal to k.

//    If n = 6, a = (9,273,63,83,93,123) and k = 3, the subroutine will return the value 4.

    public static void exercise6main(){
        int numbers[] = {9, 273, 66, 83, 93, 123, 132};
        int digit = 3;

        System.out.println(howManyNumbers(numbers, digit));

    }

    public static int howManyNumbers(int numbers[], int digit){
        int counter = 0;

        for (int number : numbers) {
            if (isLastDigitValid(number, digit) && (number % digit == 0)) {
                counter++;
            }
        }

        return counter;
    }

    public static boolean isLastDigitValid(int number, int digit){
        if (number % 10 == digit){
            return true;
        }

        return false;
    }

}
