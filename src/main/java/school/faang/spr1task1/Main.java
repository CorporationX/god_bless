package school.faang.spr1task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ReverseClass.reverse(nums);
        System.out.println("Reversed Array" + Arrays.toString(nums));
    }
}
