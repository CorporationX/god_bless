package faang.school.godbless.calculator;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println(product(List.of(1, 2, 3, 4, 5)));
        System.out.println(sum(List.of(1, 2, 3, 4, 5)));
    }

    public static <T> T calculate(List<T> nums, Calculator<T> calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("No nums in the list");
        }
        T result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }


    public static int product(List<Integer> nums) {
        return calculate(nums, (numberOne, numberTwo) -> numberOne *= numberTwo);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (numberOne, numberTwo) -> numberOne += numberTwo);
    }
}
