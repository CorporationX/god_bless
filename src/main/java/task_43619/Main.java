package task_43619;

import java.util.Arrays;

import static task_43619.Example.reverse;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
}
