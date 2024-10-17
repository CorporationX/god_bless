package school.faang.calculator.main;

import school.faang.calculator.maincode.CalculatorService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculatorService service = new CalculatorService();

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        System.out.println(service.sum(nums));
        System.out.println(service.product(nums));
    }
}
