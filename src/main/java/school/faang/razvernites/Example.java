package school.faang.razvernites;

public class Example {
    public static void reverse(int[] nums) {
        int arrayLength = nums.length;
        int temporaryPlaceholderForSwappingProcess;
        for (int i = 0; i < arrayLength / 2; i++) {
            //Stores the value of the current element at index i in the array nums:
            temporaryPlaceholderForSwappingProcess = nums[i];//Looking at the first number
            nums[i] = nums[arrayLength - i - 1];//Looking at the last number
            nums[arrayLength - i - 1] = temporaryPlaceholderForSwappingProcess;//Swapping the first and the last numbers
        }
        System.out.println("Reversed array: \n");
        for (int num : nums) {
            System.out.println(num);
        }
    }
}


