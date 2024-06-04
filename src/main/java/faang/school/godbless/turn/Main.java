package faang.school.godbless.turn;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Example.reverse(nums);
        System.out.println(Arrays.toString(nums));

        int[] numsEmpty = {};
        Example.reverse(numsEmpty);
        System.out.println(Arrays.toString(numsEmpty));

        int[] numsOne = {1};
        Example.reverse(numsOne);
        System.out.println(Arrays.toString(numsOne));
    }
}
