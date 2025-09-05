package school.faang;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] exampleArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverse(exampleArray)));
    }

    public static int[] reverse(int[] arrayUser) {
        for (int i = 0, j = arrayUser.length - 1; i < j; i++, j--) {
            int tmp = arrayUser[i];
            arrayUser[i] = arrayUser[j];
            arrayUser[j] = tmp;
        }
        return arrayUser;
    }
}