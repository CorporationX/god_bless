package school.faang.reversing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Example.reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
}
