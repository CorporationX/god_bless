package faang.school.godbless.BJS2_8988;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("произведение всех чисел равно: " + product(nums));
        System.out.println("сумма всех чисел равна: " + sum(nums));

    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        int result = nums.get(0);
        for (int i = 1; i < nums.toArray().length; i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        Calculator<Integer> calculator = (numA, numB) -> numA * numB;
        return calculate(nums, calculator);
    }

    public static int sum(List<Integer> nums) {
        Calculator<Integer> calculator = Integer::sum;
        return calculate(nums, calculator);
    }
}
