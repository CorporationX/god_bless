package faang.school.godbless.functional_interface_lambdas.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        System.out.println(product(nums));
        System.out.println(sum(nums));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {

        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("nums is null or empty");
        }

        int res = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            res = calculator.apply(res, nums.get(i));
        }

        return res;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (v1, v2) -> v1 * v2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, ((v1, v2) -> v1 + v2));
    }


}

@FunctionalInterface
interface Calculator {
    int apply(int v1, int v2);
}
