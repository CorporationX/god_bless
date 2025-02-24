package school.faang.reverse;

public class Example {

    public void reverse(int[] nums) {
        int startIndex = 0;
        int lastIndex = nums.length - 1;

        while (startIndex < lastIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[lastIndex];
            nums[lastIndex] = temp;

            startIndex++;
            lastIndex--;
        }
    }


}
