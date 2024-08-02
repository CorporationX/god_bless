package TurnAround;

public class Example {

    public static void reverse(int[] nums){
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }

    private static void swap(int[] nums,int sourceIndex,int targetIndex){
        int temp = nums[sourceIndex];
        nums[sourceIndex] = nums[targetIndex];
        nums[targetIndex] = temp;
    }

}
