package school.faang.bjs2_85493;

public class Example {
    public int[] reverse(int[] nums) {
        if (nums == null) {
            System.err.println("Нулевой массив");
            return null;
        }

        int length = nums.length;
        if (length <= 1) {
            return nums;
        } else {
            long center = Math.round((float) length / 2); //ищем середину для переворота массива
            for (int i = 0; i < center; i++) {
                int temp = nums[i];
                nums[i] = nums[length - 1 - i];
                nums[length - 1 - i] = temp;
            }
        }
        return nums;
    }
}
