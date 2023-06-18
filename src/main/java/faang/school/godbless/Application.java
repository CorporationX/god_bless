package faang.school.godbless;

import faang.school.godbless.task5.Example;

import java.util.Arrays;

public class Application {
    public static void main(String... args) {
        System.out.println("Hello World!");
        int[] array = {1, 2, 3, 4, 5};
        new Example().reverse(array);
        System.out.println(Arrays.toString(array));
    }
}
