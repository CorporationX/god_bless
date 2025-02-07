package school.faang.sprint.first.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Example.reverse(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(Example.reverse(new int[]{})));
        System.out.println(Arrays.toString(Example.reverse(new int[]{5, 8})));
        System.out.println(Arrays.toString(Example.reverse(new int[]{0})));
    }
}
