package faang.school.godbless;

public class Example {

    public static int[] reverse(int[] nums){
        if (nums.length >= 2) {
            int startPosition = 0;
            int endPosition = nums.length - 1;
            int tempValue;
            do {
                tempValue = nums[startPosition];
                nums[startPosition] = nums[endPosition];
                nums[endPosition] = tempValue;
                startPosition++;
                endPosition--;
            } while (startPosition < endPosition);
        }
        return nums;
    }
}