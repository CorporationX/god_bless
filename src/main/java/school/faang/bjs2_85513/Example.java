package school.faang.bjs2_85513;

public class Example {

    static int[] reverse(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex < endIndex) {
            int iterNum = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = iterNum;
            startIndex++;
            endIndex--;
        }

        return nums;
    }
}
