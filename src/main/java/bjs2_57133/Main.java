package bjs2_57133;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator<Integer> product = (x, y) -> x * y;
        Calculator<Integer> sum = Integer::sum;
        Calculator<String> concat = (x, y) -> String.format("%s, %s", x, y);

        List<Integer> nums = List.of(3, 5, 8, 10);

        int sumResult = calculate(0, nums, sum);
        int productResult = calculate(1, nums, product);
        String concatResult = calculate("", nums.stream().map(Object::toString).toList(), concat);

        System.out.printf("array: %s%n", concatResult.substring(2));
        System.out.printf("sum: %d%n", sumResult);
        System.out.printf("product: %d%n", productResult);
    }

    public static <T> T calculate(T initialValue, List<T> items, Calculator<T> calculator) {
        T accumulator = initialValue;

        for (T item : items) {
            accumulator = calculator.calculate(accumulator, item);
        }

        return accumulator;
    }
}