package faang.school.godbless.reverse;

import java.util.Arrays;

import static faang.school.godbless.reverse.Example.reverse;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        reverse(nums);
        System.out.println("Reversed list: " + Arrays.toString(nums));
    }
}
