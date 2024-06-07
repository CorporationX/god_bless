package Kate.BJS2_7641;

public class Example {

    public static int[] reverse(int[] nums, int lngth){
        int [] rev = new int[lngth];
        for (int i = 0; i< nums.length; i++){
            rev [nums.length -1-i] = nums[i];
            }
        return rev;
    }
}
