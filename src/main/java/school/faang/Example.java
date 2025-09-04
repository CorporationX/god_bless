package school.faang;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverse(myArray)));
    }

    public static int[] reverse(int[] array) {
        int[] revArray = new int[array.length];
        int x = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            revArray[x] = array[i];
            x++;
        }
        return revArray;
    }
}
