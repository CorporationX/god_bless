package school.faang.bjs243613;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] numbers = {-10, 631, 190, 54, 0, 12, -62};
        System.out.println(Arrays.toString(numbers));
        reverseArray(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void reverseArray(int[] array) {
        int lastIndexArray = array.length - 1;

        for (int i = 0; i < array.length / 2; i++) {
            int currentNumArray = array[i];
            array[i] = array[lastIndexArray];
            array[lastIndexArray] = currentNumArray;
            lastIndexArray--;
        }
    }
}
