package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] evenNumOfNumsArray = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.print("Source array with an even number of numbers: ");
        System.out.println(Arrays.toString(evenNumOfNumsArray));
        System.out.print("Reversed array with an even number of numbers: ");
        System.out.println(Arrays.toString(Example.reverse(evenNumOfNumsArray)));
        System.out.println();

        int[] oddNumOFNumsArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Source array with an odd number of numbers: ");
        System.out.println(Arrays.toString(oddNumOFNumsArray));
        System.out.print("Reversed array with an odd number of numbers: ");
        System.out.println(Arrays.toString(Example.reverse(oddNumOFNumsArray)));
        System.out.println();

        int[] oneElementArray = {1};
        System.out.print("Source array with one element: ");
        System.out.println(Arrays.toString(oneElementArray));
        System.out.print("Reversed array with one element: ");
        System.out.println(Arrays.toString(Example.reverse(oneElementArray)));
        System.out.println();

        int[] emptyArray = {};
        System.out.print("Source empty array: ");
        System.out.println(Arrays.toString(emptyArray));
        System.out.print("Reversed empty array: ");
        System.out.println(Arrays.toString(Example.reverse(emptyArray)));
        System.out.println();
    }
}