package faang.school.godbless.Calculator;

import java.util.List;

public class CalculatorMain {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);

        //Тестим произведение
        System.out.println(Analyzer.product(nums));

        //Тестим суммирование
        System.out.println((Analyzer.sum(nums)));
    }
}
