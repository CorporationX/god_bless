package faang.school.godbless.turn_around;

import java.util.Arrays;

import static faang.school.godbless.turn_around.Example.reverse;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("До: " + Arrays.toString(nums));
        reverse(nums);
        System.out.println("После: " + Arrays.toString(nums));
    }
}

