package school.faang.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] result = Example.reverse(nums);
        System.out.println(Arrays.toString(result));
    }
}
