package faang.school.godbless.basic.reverse;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,7,9};
        Example.reverse(nums);
        System.out.println("Original nums: " + Arrays.toString(nums));
    }
}
