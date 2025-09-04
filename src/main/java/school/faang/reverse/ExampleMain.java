package school.faang.reverse;

import java.util.Arrays;

public class ExampleMain {
    public static void main(String[] args) {
        Example qwer = new Example();

        int[] nums = { 1, 2, 3, 4, 5 };
        int[] reversedNums = qwer.reverse(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(reversedNums));
    }
}
