package school.faang.bjs2_85530;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reversedArray(nums)));
    }

    public static int[] reversedArray(int[] sourceNums) {
        int[] reverseNums = new int[sourceNums.length];
        for (int i = sourceNums.length - 1; i >= 0; i--) {
            reverseNums[sourceNums.length - i - 1] = sourceNums[i];
        }
        return reverseNums;
    }

}