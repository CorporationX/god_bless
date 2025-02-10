package school.faang;

public class Example {
    public static int[] reverse(int[] nums) {
        int pointerOne = 0;
        int pointerTwo = nums.length - 1;

        while (pointerOne < pointerTwo) {
            int temp = nums[pointerOne];
            nums[pointerOne] = nums[pointerTwo];
            nums[pointerTwo] = temp;
            pointerOne++;
            pointerTwo--;
        }
        return nums;
    }
}
