package faang.school.godbless;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int product = CalculatorProcessor.product(userNumbers);
        int sum = CalculatorProcessor.sum(userNumbers);
        System.out.println(product);
        System.out.println(sum);
    }
}