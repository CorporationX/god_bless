package school.faang.reverse.array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        System.out.println(Arrays.toString(example.reverse(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(example.reverse(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));
        System.out.println(Arrays.toString(example.reverse(new int[]{3})));
        System.out.println(Arrays.toString(example.reverse(new int[]{})));
    }
}
