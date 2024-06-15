package faang.school.godbless.calculator;

import java.util.List;

public class Main {
    private static final List<Integer> NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int calculate(List<Integer> nums,
                                Calculator calculator) throws IllegalArgumentException {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.doAnything(result, nums.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(product(NUMBERS));
        System.out.println(sum(NUMBERS));
    }
}
