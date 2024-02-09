package Task5;

public class Example {
    public static int[] reverse(int[] nums){
        /**
         * сделал два варианта
         */
//        int[] array = new int[nums.length];
//        for(int i = 0; i < nums.length; i++){
//            array[i] = nums[nums.length - i - 1];
//        }
//        return array;

        for(int i = 0; i < nums.length/2; i++){
            int n = nums[i];
            nums[i] = nums[nums.length - i -1];
            nums[nums.length - i - 1] = n;
        }
        return nums;
    }
}
