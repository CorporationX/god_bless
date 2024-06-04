package BJS_7632;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] reverseArray = Example.reverse(array);

        System.out.format("Reverse array: %s", Arrays.toString(reverseArray));
    }
}