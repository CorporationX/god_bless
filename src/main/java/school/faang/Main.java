package school.faang;

import java.util.Arrays;

import static school.faang.Example.reverse;

public class Main {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};

        System.out.println("Old nums is: " + Arrays.toString(nums));
        reverse(nums);
        System.out.println("Reverse nums is: " + Arrays.toString(nums));
    }
}
