package school.faang.BJS2_56375;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int [] nums = {1, 2, 4, 765, 6, 2};
        example.reverse(nums);
        System.out.println("Reversed array: " + Arrays.toString(nums));
    }
}
