package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("До разворота: " + Arrays.toString(nums));
        Example.reverse(nums);
        System.out.println("После разворота: " + Arrays.toString(nums));
    }
}
