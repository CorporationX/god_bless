package faang.school.godbless;


import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Calculator<T> {
    T apply(T firstValue, T secondValue);
}

class CalculatorApp {
    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.apply(result, nums.get(i));
        }
        return result;

    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (firstValue, secondValue) -> firstValue * secondValue);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (firstValue, secondValue) -> firstValue + secondValue);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        product(nums);
        sum(nums);
        System.out.print("Произведение всех чисел равна " + product(nums));
        System.out.println();
        System.out.print("Сумма всех чисел равна " + sum(nums));
    }
}







