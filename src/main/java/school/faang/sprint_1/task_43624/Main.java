package school.faang.sprint_1.task_43624;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 500, 123, 123, 123, 123, 123, 123, 12, 312};

        System.out.println(Arrays.toString(nums));
        Example.reverse(nums);
        System.out.println(Arrays.toString(nums));

    }
}
