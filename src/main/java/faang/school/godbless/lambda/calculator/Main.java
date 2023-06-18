package faang.school.godbless.lambda.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(-1, 2, 2, 4));

        System.out.println("Result of sum each element: " + CalcMethods.sum(numbers));
        System.out.println("Result of product each element: " + CalcMethods.product(numbers));
    }
}
