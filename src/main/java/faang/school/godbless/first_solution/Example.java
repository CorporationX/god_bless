package faang.school.godbless.first_solution;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 7, 8, 12};
        reverse(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void reverse(int[] array) {
        for (int number = 0; number < array.length / 2; number++) {
            int tmp = array[number];
            array[number] = array[array.length - number - 1];
            array[array.length - number - 1] = tmp;
        }
    }
}
