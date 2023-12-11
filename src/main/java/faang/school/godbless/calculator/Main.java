package faang.school.godbless.calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        System.out.println(sum(numbers));
        System.out.println(product(numbers));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calc(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

}
