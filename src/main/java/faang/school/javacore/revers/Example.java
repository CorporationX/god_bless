package faang.school.javacore.revers;

public class Example {
    public void reverse (int [] nums){
        for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}
