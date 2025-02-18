package bjs2_57133;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator<Integer> product = (x, y) -> x * y;
        Calculator<Integer> sum = Integer::sum;

        List<Integer> nums = List.of(3, 5, 8, 10);

        int sumResult = CalculationRunner.calculate(nums, sum);
        int productResult = CalculationRunner.calculate(nums, product);

        System.out.printf("array: %s%n", nums);
        System.out.printf("sum: %d%n", sumResult);
        System.out.printf("product: %d%n", productResult);
    }
}