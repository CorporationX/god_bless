package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        int[] reversedArray = Example.reverse(nums);

        System.out.printf("%s -> %s%n", Arrays.toString(nums), Arrays.toString(reversedArray));

        nums = new int[] { 1, 2, 3, 4 };
        reversedArray = Example.reverse(nums);

        System.out.printf("%s -> %s%n", Arrays.toString(nums), Arrays.toString(reversedArray));

        nums = new int[0];
        reversedArray = Example.reverse(nums);

        System.out.printf("%s -> %s%n", Arrays.toString(nums), Arrays.toString(reversedArray));
    }
}
