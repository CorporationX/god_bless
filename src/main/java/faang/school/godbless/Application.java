package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Example example = new Example();
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        outputArray(nums);
        outputArray(example.reverse(nums));
    }
    private static void outputArray(int[] nums){
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }
}