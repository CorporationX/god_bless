package school.faang.bjs2_85493;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example arr1 = new Example();
        int[] nums = {1, 2, 3, 4, 5};
        int[] numsReverse = arr1.reverse(nums);
        System.out.println(Arrays.toString(numsReverse));
    }
}
