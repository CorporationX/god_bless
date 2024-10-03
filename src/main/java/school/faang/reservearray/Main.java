package school.faang.reservearray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5};
        Example user = new Example();
        int[] arrayNumsbers = user.reserve(nums);
        System.out.println(Arrays.toString(arrayNumsbers));
    }
}
