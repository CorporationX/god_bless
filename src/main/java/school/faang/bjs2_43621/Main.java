package school.faang.bjs2_43621;

public class Main {
    public static void main(String[] args) {
        var main = new Main();
        int[] nums = {1, 2, 3, 4, 5};
        main.reverse(nums);
    }

    public void reverse(int[] nums) {
        int firstIndex = 0;
        int lastIndex = nums.length - 1;
        while (firstIndex < lastIndex) {
            int value = nums[firstIndex];
            nums[firstIndex] = nums[lastIndex];
            nums[lastIndex] = value;

            firstIndex++;
            lastIndex--;
        }
    }
}
