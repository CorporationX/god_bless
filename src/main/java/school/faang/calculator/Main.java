package school.faang.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        MathOperations mathOperations = new MathOperations();

        System.out.println(mathOperations.product(numbers));
        System.out.println(mathOperations.sum(numbers));

    }
}
