package school.faang.BJS243610;

public class Reverse {
    public int[] reverse(int[] nums) {
        int indexFirst = 0;
        int indexLast = nums.length - 1;

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[indexFirst];
            nums[indexFirst] = nums[indexLast];
            nums[indexLast] = temp;
            indexFirst++;
            indexLast--;
        }

        return nums;
    }
}
