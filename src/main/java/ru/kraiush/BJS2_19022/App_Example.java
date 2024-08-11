package ru.kraiush.BJS2_19022;

import java.util.Arrays;
import java.util.Collections;

public class App_Example {

    public static void main(String[] args) {

        int[] aint = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(Arrays.toString(aint));

        Integer[] aInt = new Integer[aint.length];
        Arrays.setAll(aInt, i -> aint[i]);

        reverseUseTempArr(aint);

        reverseUseFunction(aInt);
    }

    static void reverseUseFunction(Integer a[])
    {
        Collections.reverse(Arrays.asList(a));
        System.out.println("\nReversed array is:");
        System.out.println(Arrays.asList(a));
    }

    static void reverseUseTempArr(int a[])
    {
        int[] b = new int[a.length];
        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        System.out.println("Reversed array is:");
        for (int k = 0; k < a.length; k++) {
            System.out.print(b[k] + " ");
        }
    }
}




