package faang.school.godbless.lamdbastreamapi.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final Map<String, Calculator<Integer>> CALCULATOR = new HashMap<>();

    public static void main(String[] args) {
        CALCULATOR.put("sum", (a, b) -> a + b);
        CALCULATOR.put("product", (a, b) ->  a * b);

        List<Integer> nums = new ArrayList<>(List.of(2, 3, 4, 5));
        System.out.println("Сумма: " + sum(nums));
        System.out.println("Произведение: " + product(nums));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        int result = calculator.calculate(nums.get(0), nums.get(1));
        for (int i = 2; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, CALCULATOR.get("product"));
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, CALCULATOR.get("sum"));
    }
}
