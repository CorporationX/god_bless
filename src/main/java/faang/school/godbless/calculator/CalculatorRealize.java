package faang.school.godbless.calculator;

import java.util.List;
import java.awt.*;

public class CalculatorRealize {
    public static int calculate(List<Integer> nums, Calculator calculator) {
        if(nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        int result = nums.get(0);
        for(int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, ((a, b) -> a + b));
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, ((a, b) -> a * b));
    }

    public static void main(String[] args) {
        System.out.println(sum(List.of(5, 7, 10, 5)));
        System.out.println(product(List.of(2, 2, 3, 5)));
    }

}
