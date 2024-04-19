package faang.school.godbless.sprint2.lambda.calculator;

import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        try {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, -1, -2);

            System.out.println("Sum of numbers: " + Operations.sum(numbers));
            System.out.println("Product of numbers: " + Operations.product(numbers));
            System.out.println("Sum of numbers: " + Operations.sum(null));
        } catch (IllegalArgumentException ex) {
            System.out.println("An exception: " + ex.getMessage());
        }
    }
}
