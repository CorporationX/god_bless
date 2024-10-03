package school.faang.turn_around;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var nums = new int[]{1, 2, 3, 4, 5};
        Example.reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
}
