package school.faang.bjs2_80160;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4);

        int sumResult = sum(numbers);
        int productResult = product(numbers);

        System.out.println("Сумма чисел: " + sumResult);
        System.out.println("Произведение чисел: " + productResult);
    }

    public static int calculate(List<Integer> nums, Calculator calculator) {
        return nums.stream()
                .reduce(calculator::apply)
                .orElseThrow(() -> new IllegalArgumentException("nums is null or empty"));
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
