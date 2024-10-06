package school.faang.reservearray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5};
        Example user = new Example();
        System.out.println(Arrays.toString(user.reserve(nums)));
    }
}
