package school.faang.turn_around;

import java.util.Arrays;

import static school.faang.turn_around.Example.reverse;

public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(reverse(new int[]{1, 3, 3, 4, 10})));
        System.out.println(Arrays.toString(reverse(new int[]{0, 0, 5, 0, 0})));
        System.out.println(Arrays.toString(reverse(new int[]{111, 11, 1, 0, -1})));
        System.out.println(Arrays.toString(reverse(new int[]{1, -3, 5, 6, -7})));
    }
}
