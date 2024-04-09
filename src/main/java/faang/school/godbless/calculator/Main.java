package faang.school.godbless.calculator;

import java.util.List;
import static faang.school.godbless.calculator.CalculatorProcessor.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        System.out.println("The sum is: " + sum(nums));
        System.out.println("The product is: " + product(nums));
    }
}
