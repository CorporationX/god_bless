package school.faang.turn_around_BJS2_31467;

import java.util.Arrays;

public class Example {

    public int[] reverse(int[] numbers) {
        for (int i = 0; i < (numbers.length) / 2; i++) {
            int temp = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = numbers[i];
            numbers[i] = temp;
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Example example = new Example();

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(example.reverse(numbers)));
    }
}

