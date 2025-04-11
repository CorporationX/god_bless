package school.faang.array.reverse;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Example.reverse(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(Example.reverse(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));
        System.out.println(Arrays.toString(Example.reverse(new int[]{3})));
        System.out.println(Arrays.toString(Example.reverse(new int[]{})));
    }
}
