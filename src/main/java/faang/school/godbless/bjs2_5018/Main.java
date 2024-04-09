package faang.school.godbless.bjs2_5018;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        product(numbers);
        sum(numbers);
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calc(nums.get(i), result);
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        int result = calculate(nums, (num1, num2) -> num1 * num2);
        log.info("Product of numbers {}. Result: {}", nums, result);
        return result;
    }

    public static int sum(List<Integer> nums) {
        int result =  calculate(nums, Integer::sum);
        log.info("Sum of numbers {}. Result: {}", nums, result);
        return result;
    }
}
