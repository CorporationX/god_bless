package faang.school.godbless.functionalInterfaces.calculator;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CalculationProcessor {
    public static double calculate(List<Double> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || calculator == null) {
            throw new IllegalArgumentException("Params cannot be null-valued!");
        }

        if (nums.size() < 2) {
            throw new IllegalArgumentException("List of nums must contain at least two numbers!");
        }

        double result = nums.get(0); //Начинаем обход списка с первого элемента

        //Обходим список со второго элемента, так как первый уже находится в result
        for (var num : nums.subList(1, nums.size())) {
            result = calculator.apply(result, num);
        }

        return result;
    }

    public static double product(List<Double> nums) throws IllegalArgumentException {
        return calculate(nums, (firstOperand, secondOperand) -> firstOperand * secondOperand);
    }

    public static double sum(List<Double> nums) throws IllegalArgumentException {
        return calculate(nums, Double::sum);
    }

    public static double division(List<Double> nums) throws IllegalArgumentException {
        if (nums.subList(1, nums.size()).contains(0.0)) {
            throw new IllegalArgumentException("Division by zero is not allowed!");
        }

        return calculate(nums, (firstOperand, secondOperand) -> firstOperand / secondOperand);
    }
}
