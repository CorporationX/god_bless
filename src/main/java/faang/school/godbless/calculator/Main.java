package faang.school.godbless.calculator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> bigNumbers = Arrays.asList(100000, 100000);
        List<Integer> numbers1 = List.of();
        System.out.println("Умножение: " + multiplication(numbers));
        System.out.println("Сумма: " + sum(numbers));
        System.out.println("Умножение больших чисел: " + multiplication(bigNumbers));
        System.out.println("Умножение: " + multiplication(numbers1));

    }
    public static <T> T calculate(List<T> nums, Calculator<T> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Лист пуст");
        }

        T result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static BigInteger multiplication(List<Integer> nums) {
        List<BigInteger> bigIntegers = nums.stream()
                .map(BigInteger::valueOf)
                .collect(Collectors.toList());
        return calculate(bigIntegers, (a, b) -> a.multiply(b));
    }

    public static BigInteger sum(List<Integer> nums) {
        List<BigInteger> bigIntegers = nums.stream().map(BigInteger::valueOf).collect(Collectors.toList());
        return calculate(bigIntegers, (a, b) -> a.add(b));
    }
}
