package faang.school.godbless.module.second.lambda.calculator;

import java.util.List;

import static faang.school.godbless.module.second.lambda.calculator.CalculatorService.product;
import static faang.school.godbless.module.second.lambda.calculator.CalculatorService.sum;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        System.out.println(sum(nums));
        System.out.println(product(nums));
    }
}
