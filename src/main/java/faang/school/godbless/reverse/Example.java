package faang.school.godbless.reverse;

public class Example {
    public static int[] reverse(int[] nums){
        if(nums.length<=1) return nums;
        int start = 0;
        int end = nums.length -1;
        while(start<end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
        return nums;
    }
}
