package faang.school.godbless.r_edzie.calc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(sum(numbers));
        System.out.println(product(numbers));
    }

    public static <T> T calculate(List<T> numbers, Calculator<T> calculator) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        return numbers.stream().reduce(calculator::calculate).orElseThrow();
    }

    public static int product(List<Integer> numbers) {
        return calculate(numbers, (x, y) -> x * y);
    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, Integer::sum);
    }
}
