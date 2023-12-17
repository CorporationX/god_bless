package faang.school.godbless.BJS2_796;

import java.math.BigInteger;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

        System.out.println(sum(numbers));
        System.out.println(produce(numbers));
    }

    public static BigInteger sum(List<Integer> numbers) {
        return calculate(numbers, BigInteger::add);
    }

    public static BigInteger produce(List<Integer> numbers) {
        return calculate(numbers, BigInteger::multiply);
    }

    public static BigInteger calculate(List<Integer> numbers, Calculator calculator) throws IllegalArgumentException {
        if (numbers == null) {
            throw new IllegalArgumentException("List is null");
        }
        return numbers.stream()
                .map(BigInteger::valueOf)
                .reduce(calculator::operate).orElse(BigInteger.ZERO);
    }
}