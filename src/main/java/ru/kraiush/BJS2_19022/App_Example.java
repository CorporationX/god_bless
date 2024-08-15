package ru.kraiush.BJS2_19022;

import java.util.Arrays;
import java.util.Collections;

public class App_Example {

    public static void main(String[] args) {

        int[] array_int = {1,2,3,4,5,6,7,8,9,10};
        System.out.print(String.join("", Collections.nCopies(60, "-")));
        System.out.println("\nInitial array");
        System.out.println(Arrays.toString(array_int));

        Integer[] array_Integer = new Integer[array_int.length];
        Arrays.setAll(array_Integer, i -> array_int[i]);

        reverseUseFunction(array_Integer);
        reverseUseTempArr(array_int);
        System.out.println();
        System.out.print(String.join("", Collections.nCopies(60, "-")));
    }

    static void reverseUseFunction(Integer array[]) {
        Collections.reverse(Arrays.asList(array));
        System.out.println("\nReversed arrayay by use Collection's reverse:");
        System.out.println(Arrays.asList(array));
    }

    static void reverseUseTempArr(int array[]) {
        int[] reversedArray = new int[array.length];
        int j = array.length -1;
        for (int i = 0; i < array.length; i++) {
            reversedArray[j] = array[i];
            j = j - 1;
        }
        System.out.println("\nReversed arrayay by use temp array:");
        for (int k = 0; k < array.length; k++) {
            System.out.print(reversedArray[k] + " ");
        }
    }
}




