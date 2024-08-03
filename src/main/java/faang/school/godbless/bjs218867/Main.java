package faang.school.godbless.bjs218867;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{11, 2, 3, 4, 5, 12, 18};
        Example example = new Example();
        int[] result = example.reverse(nums);
        System.out.println(Arrays.toString(result));
    }
}
