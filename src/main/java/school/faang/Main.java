package school.faang;

import school.faang.service.Example;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(Example.reverse(nums)));
    }
}
