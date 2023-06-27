package faang.school.godbless.reverse;

import java.util.Arrays;

public class Application {
    public static void main(String... args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(numbers));
        Example.reverse(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
