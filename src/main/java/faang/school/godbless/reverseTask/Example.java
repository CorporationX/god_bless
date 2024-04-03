package faang.school.godbless.reverseTask;

public class Example {
    public static int[] reverse(int[] nums) {
        int[] numsCopy = nums.clone();
        int temp;

        for (int i = 0; i < numsCopy.length / 2; i++) {
            temp = numsCopy[i];
            numsCopy[i] = numsCopy[numsCopy.length - i - 1];
            numsCopy[numsCopy.length - i - 1] = temp;
        }
        return numsCopy;
    }
}
