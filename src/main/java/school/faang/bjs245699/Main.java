package school.faang.bjs245699;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        System.out.println(sum(numbers));
        System.out.println(product(numbers));
    }

    public static int calculate(List<Integer> numbers, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        return numbers.stream()
                .reduce(numbers.get(0), calculator::calculate);
    }

    public static int product(List<Integer> numbers) {
        return calculate(numbers, (a, b) -> a * b);

    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, Integer::sum);
    }
}