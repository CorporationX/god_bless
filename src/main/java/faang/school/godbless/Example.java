package faang.school.godbless;

public class Example {

    public static int[] reverse(int nums[]) {

        if (nums != null) {
//            for (int i = (nums.length - 1); i > 0; i--) {
//                if (i == k) {
//                    return nums;
//                } else if (k < i) {
//                    int number = nums[k];
//                    nums[k] = nums[i];
//                    nums[i] = number;
//                } else {
//                    return nums;
//                }
//                k++;
//            }
            int k = 0;
            int i = nums.length - 1;
            while (k < i) {
                int number = nums[k];
                nums[k] = nums[i];
                nums[i] = number;
                i--;
                k++;
            }
        }
        return nums;
    }
}