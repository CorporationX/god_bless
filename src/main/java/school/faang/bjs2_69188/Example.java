package school.faang.bjs2_69188;

public class Example {
    public static int[] reverse(int[] nums) {
        int[] reversedNums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            reversedNums[i] = nums[nums.length - 1 - i];
            System.out.println(reversedNums[i]);
        }

        return reversedNums;
    }
}
