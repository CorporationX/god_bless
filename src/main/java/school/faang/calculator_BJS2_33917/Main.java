package school.faang.calculator_BJS2_33917;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(12, 34, 54, 76));

        System.out.println(sum(numbers));
        System.out.println(product(numbers));
    }

    public static int calculate(List<Integer> numbers, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (numbers.isEmpty()) throw new IllegalArgumentException("List is empty");
        int total = numbers.get(0);
        for (int i = 1; i < numbers.size(); ++i) {
            total = calculator.calculate(total, numbers.get(i));
        }
        return total;
    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, (num1, num2) -> num1 + num2);
    }

    public static int product(List<Integer> numbers) {
        return calculate(numbers, (num1, num2) -> num1 * num2);
    }
}


