package reverse;

public class Example {
    public static void main (String[] args){
        int[] nums = {1, 2, 3, 4, 5};
        int[] revNums = reverse (nums);
        for(int i: revNums){
            System.out.println(i);
        }

    }

    public static int[] reverse(int[] nums){
        int[] revNums = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            revNums[i]=nums[nums.length-i-1];
        }
        return revNums;
    }
}
