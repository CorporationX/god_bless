package school.faang.bjs2_79180;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] evenArray = {1, 2, 3, 4};
        System.out.println("Reversing " + Arrays.toString(evenArray));
        Example.reverse(evenArray);
        System.out.println("Result    " + Arrays.toString(evenArray));

        int[] oddArray = {1, 2, 3, 4, 5};
        System.out.println("Reversing " + Arrays.toString(oddArray));
        Example.reverse(oddArray);
        System.out.println("Result    " + Arrays.toString(oddArray));

        int[] singleArray = {1};
        System.out.println("Reversing " + Arrays.toString(singleArray));
        Example.reverse(singleArray);
        System.out.println("Result    " + Arrays.toString(singleArray));

        int[] emptyArray = {};
        System.out.println("Reversing " + Arrays.toString(emptyArray));
        Example.reverse(emptyArray);
        System.out.println("Result    " + Arrays.toString(emptyArray));

        int[] nullArray = null;
        System.out.println("Reversing " + Arrays.toString(nullArray));
        Example.reverse(nullArray);
        System.out.println("Result    " + Arrays.toString(nullArray));
    }
}
