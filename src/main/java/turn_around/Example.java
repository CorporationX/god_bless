package turn_around;

import java.util.Arrays;

public class Example {

    public static void main(String[] args) {
        int[] myArray = {4, 5, 8, 9, 10, 15};
        System.out.println(Arrays.toString(reverse(myArray)));
    }

    public static int[] reverse(int[] numbersArray) {
        int[] resultArray = new int[numbersArray.length];
        int j = numbersArray.length - 1;
        for (int i = 0; i < numbersArray.length; i++) {
            resultArray[j] = numbersArray[i];
            j--;
        }
        return resultArray;
    }
}
