package school.faang.task2111;

import school.faang.task2111.calculator.CalculatorService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(CalculatorService.product(List.of(1,2,3,4,5,6,7,8,9)));
        System.out.println(CalculatorService.sum(List.of(1,2,3,4,5,6,7,8,9)));
    }
}
