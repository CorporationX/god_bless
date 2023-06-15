package faang.school.godbless;

public class Example {
    public static int[] reverse(int nums[]) {
        int[] result = new int[nums.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = nums[nums.length - 1 - i];
        }
        return result;
    }
}
