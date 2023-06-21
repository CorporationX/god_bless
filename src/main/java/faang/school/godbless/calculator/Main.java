package faang.school.godbless.calculator;

import faang.school.godbless.calculator.interfaces.Calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(product(List.of(1, 2, 3, 4, 5)));
        System.out.println(sum(List.of(1, 2, 3, 4, 5)));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.apply(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (p1, p2) -> p1 *= p2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (p1, p2) -> p1 += p2);
    }
}
