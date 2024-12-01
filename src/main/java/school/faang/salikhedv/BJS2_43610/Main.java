package school.faang.salikhedv.BJS2_43610;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Reverse reverse = new Reverse();

        int[] nums = {1, 2, 3, 4};
        int[] result = reverse.reverse(nums);

        System.out.println(Arrays.toString(result));
    }
}
