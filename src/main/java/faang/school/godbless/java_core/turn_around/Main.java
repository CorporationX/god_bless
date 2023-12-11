package faang.school.godbless.java_core.turn_around;

import java.util.Arrays;

import static faang.school.godbless.java_core.turn_around.Example.reverse;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        reverse(nums);
        System.out.println(Arrays.toString(nums));

    }
}
