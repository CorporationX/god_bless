package school.faang.BJS2_56481;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Example.reverse(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(Example.reverse(new int[]{1})));
        System.out.println(Arrays.toString(Example.reverse(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(Example.reverse(new int[]{1, 2, 3, 4, 5, -1, -2})));
        System.out.println(Arrays.toString(Example.reverse(new int[]{}))); //все тесты пройдены!
    }
}