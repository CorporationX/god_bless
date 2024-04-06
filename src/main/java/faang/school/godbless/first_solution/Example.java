package faang.school.godbless.first_solution;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 7, 8, 12};
        reverse(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
    }
}
