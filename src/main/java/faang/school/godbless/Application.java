package faang.school.godbless;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        test(new int[]{1});
        test(new int[]{1, 2});
        test(new int[]{1, 2, 3, 4, 5});
        test(new int[]{1, 2, 3, 4, 5, 6});
    }

    static void test(int[] array) {
        System.out.println("Original " + Arrays.toString(array));
        System.out.println("Reversed " + Arrays.toString(Example.reverse(array)));
    }
}