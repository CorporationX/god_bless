package school.faang.task_43629;

import java.util.Arrays;

public class Main {
    private static final Example example = new Example();

    public static void main(String[] args) {
        printResult(new int[]{1, 2, 3, 4});
        printResult(new int[]{1, 2, 3, 4, 5});
    }

    private static void printResult(int[] nums) {
        System.out.printf("Input: %s\n", Arrays.toString(nums));
        System.out.printf("Output: %s\n\n", Arrays.toString(example.reverse(nums)));
    }

}
