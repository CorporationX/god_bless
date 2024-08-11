package ru.kraiush.BJS2_19022;

import java.util.Arrays;
import java.util.Collections;

public class App_Example {

    public static void main(String[] args) {

        int[] aint = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Init array:");
        System.out.println(Arrays.toString(aint));

        Integer[] aInt = new Integer[aint.length];
        Arrays.setAll(aInt, i -> aint[i]);

        reverseUseTempArr(aint);
        reverseUseFunction(aInt);
    }

    static void reverseUseFunction(Integer array[]) {
        Collections.reverse(Arrays.asList(array));
        System.out.println("\nReversed array using Collections.reverse() is:");
        System.out.println(Arrays.asList(array));
    }

    static void reverseUseTempArr(int array[]) {
        int[] b = new int[array.length];
        int j = array.length;
        for (int i = 0; i < array.length; i++) {
            b[j - 1] = array[i];
            j = j - 1;
        }
        System.out.println("Reversed array using Temp array is:");
        for (int k = 0; k < array.length; k++) {
            System.out.print(b[k] + " ");
        }
    }
}
