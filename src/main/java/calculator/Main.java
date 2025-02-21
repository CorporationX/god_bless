package calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, -3, 4, 5);

        Calculator.sum(numbers);
        Calculator.multiply(numbers);
    }
}