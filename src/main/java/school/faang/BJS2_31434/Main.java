package school.faang.BJS2_31434;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Example example = new Example();
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("Before reverse: " + Arrays.toString(nums));
            example.reverse(nums);
        System.out.println("After reverse: " + Arrays.toString(nums));
    }
}
