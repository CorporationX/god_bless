package faang.school.godbless.Calculator;

import faang.school.godbless.Calculator.function.GooglCalculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 3, 4);
        System.out.println(GooglCalculator.sum(list));
    }
}
