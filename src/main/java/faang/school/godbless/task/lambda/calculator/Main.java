package faang.school.godbless.task.lambda.calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 2, 2, 2);

        int product = product(nums);
        System.out.println("Результат умножения: " + product);

        int sum = sum(nums);
        System.out.println("Результат суммирования: " + sum);
        
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Список чисел не может быть пустым");
        }
        Integer result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        Calculator multiplication = (numb1, numb2) -> numb1 * numb2;
        int result = calculate(nums, multiplication);
        return result;
    }

    public static int sum(List<Integer> nums) {
        Calculator summation = (numb1, numb2) -> numb1 + numb2;
        int result = calculate(nums, summation);
        return result;
    }
}
