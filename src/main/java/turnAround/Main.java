package turnAround;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 5, 12, 75, 4, 3};
        Example example = new Example();

        System.out.println(Arrays.toString(nums));
        example.reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
}
