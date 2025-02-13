package school.faang.razvernites;

public class Example {
    public static int[] reverse(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        if (nums.length == 1) {
            return nums;
        } else {
            while (leftIndex < rightIndex) {
                int temp = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }
        return nums;
    }
}
