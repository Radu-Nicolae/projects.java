public class Exercise7 {

    public static void exercise7main(){
//        Give a non-natural number n. Calculate the sum of the digits of n that are greater
//        than or equal to 3 and less than or equal to 7.

        System.out.print("Enter the integer: ");
        int n = Utilities.getValidInteger();
        int sum = 0;
        int digit;

        while (n > 0){
            digit = n % 10;
            if (3 <= digit && digit <= 7){
                sum += digit;
            }
            n /= 10;
        }

        System.out.println(sum);
    }
}
