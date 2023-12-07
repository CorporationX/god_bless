package faang.school.godbless.javacore.reverse;

public class Example {

    public void reverse(int[] nums) {
        int leftPoint = 0;
        int rightPoint = nums.length - 1;
        while (leftPoint < rightPoint) {
            int tempNumber = nums[leftPoint];
            nums[leftPoint] = nums[rightPoint];
            nums[rightPoint] = tempNumber;
            leftPoint++;
            rightPoint--;
        }
    }

}
