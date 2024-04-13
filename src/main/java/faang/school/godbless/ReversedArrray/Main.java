package faang.school.godbless.ReversedArrray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        example.bubbleSort(nums);
        System.out.println("Reversed list: " + Arrays.toString(nums));
    }
}
