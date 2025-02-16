package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] evenNumOfNumbersArray = {1, 2, 3, 4, 5, 6};
        System.out.print("Source array with an even number of numbers: ");
        System.out.println(Arrays.toString(evenNumOfNumbersArray));
        System.out.print("Reversed array with an even number of numbers: ");
        System.out.println(Arrays.toString(Example.reverse(evenNumOfNumbersArray)));
        System.out.println();

        int[] oddNumOfNumsArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Source array with an odd number of numbers: ");
        System.out.println(Arrays.toString(oddNumOfNumsArray));
        System.out.print("Reversed array with an odd number of numbers: ");
        System.out.println(Arrays.toString(Example.reverse(oddNumOfNumsArray)));
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