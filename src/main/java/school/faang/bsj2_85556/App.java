package school.faang.bsj2_85556;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        final int[] ints = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        System.out.println(Arrays.toString(Example.reverse(ints)));

        int[] a = {};

        System.out.println(Arrays.toString(Example.reverse(a)));
    }
}