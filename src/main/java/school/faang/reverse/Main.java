package school.faang.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        numbers = Example.reverse(numbers);
        if (numbers != null) {
            System.out.println(Arrays.toString(numbers));
        }
    }
}
