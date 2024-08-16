package BJS2_21480_Calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(Operations.sum(nums));
        System.out.println(Operations.product(nums));
    }
}
