package school.faang.bjs_43645;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        testReverse(new int[]{});
        testReverse(new int[]{1});
        testReverse(new int[]{1, 2, 3, 4, 5});
        testReverse(new int[]{1, 2, 3, 4, 5, 6});
    }

    private static void testReverse(int[] nums) {
        NumsUtils numsUtils = new NumsUtils();
        System.out.println("Normal nums:" + Arrays.toString(nums));
        numsUtils.reverse(nums);
        System.out.println("Reverse nums:" + Arrays.toString(nums));
    }
}
