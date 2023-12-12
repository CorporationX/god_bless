package JavaCore_5;

public class Example {

    public static int[] reverse(int[] nums){
        int[] numsReverse = new int[nums.length];
        for (int i = 0; i<=nums.length-1; i++){
            numsReverse[i] = nums[nums.length-1-i];
        }
        return numsReverse;
    }

}
