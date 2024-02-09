package Task5;

public class Example {
    public static int[] reverse(int[] nums){
        int[] array = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            array[i] = nums[nums.length - i - 1];
        }
        return array;
    }
}
