package school.faang.reverse;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        int[] result = Example.reverse(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(result));
    }
}