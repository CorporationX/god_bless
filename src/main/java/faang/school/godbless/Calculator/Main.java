package faang.school.godbless.Calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 3, 5, 6);
        int prod = product(nums);
        int sum = sum(nums);
        System.out.println("prod: " + prod);
        System.out.println("sum: " + sum);
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        } else if (nums.size() < 2) {
            throw new IllegalArgumentException("List size less than 2");
        }

        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            res = calculator.calculate(res, nums.get(i));
        }
        return res;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}
