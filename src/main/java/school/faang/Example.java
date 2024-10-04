package school.faang;

public class Example {
    public static int[] reverse(int[] nums) {
        int[] reversedArray = new int[nums.length];
        int count = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            reversedArray[i] = nums[count];
            count--;
        }
        return reversedArray;
    }
}
