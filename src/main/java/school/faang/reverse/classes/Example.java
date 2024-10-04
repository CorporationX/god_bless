package school.faang.reverse.classes;

public class Example {
    public static int[] reverse(int[] nums) {
        int[] newArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            newArray[i] = nums[nums.length -1 - i];
        }
        return newArray;
    }
}
