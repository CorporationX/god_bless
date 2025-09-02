package school.faang.bjs2_85457;

import java.util.Arrays;

public class Example {

    public static void reverse (int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] rev = {1, 2, 3, 4, 5};
        int [] original = rev.clone();

        reverse(rev);

        System.out.println(Arrays.toString(rev));
        System.out.println(Arrays.toString(original));
    }
}
