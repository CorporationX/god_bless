package faang.school.godbless.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 4));

        int product = Operations.product(nums);
        int sum = Operations.sum(nums);

        System.out.println(product);
        System.out.println(sum);
    }
}
