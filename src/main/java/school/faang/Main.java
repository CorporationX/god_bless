package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Example example = new Example();

        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("The array before the coup: " + Arrays.toString(nums));

        example.reverse(nums);

        System.out.println("The array after the coup: " + Arrays.toString(nums));
    }
}