package school.faang.turnaround;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("Original array: " + Arrays.toString(nums));
        example.reverse(nums);
        System.out.println("Reversed array: " + Arrays.toString(nums));
    }
}