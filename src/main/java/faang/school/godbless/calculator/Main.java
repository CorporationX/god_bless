package faang.school.godbless.calculator;

import java.math.BigInteger;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static BigInteger calculate(List<Integer> nums, Calculator<BigInteger> calculator) {
        BigInteger result = BigInteger.valueOf(nums.get(0));
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, BigInteger.valueOf(nums.get(i)));
        }
        return result;
    }

    public static BigInteger product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a.multiply(b));
    }

    public static BigInteger sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a.add(b));
    }
}