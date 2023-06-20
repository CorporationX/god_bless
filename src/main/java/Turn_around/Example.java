package Turn_around;

public class Example {
    public static int[] reverse(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int tempStorage = 0;
        while (left<right){
            tempStorage = nums[left];
            nums[left] = nums[right];
            nums[right] = tempStorage;
            left++;
            right--;
        }
        return nums;
    }
}

