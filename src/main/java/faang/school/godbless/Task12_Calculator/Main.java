package faang.school.godbless.Task12_Calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        Calculate calculate = new Calculate();
        numbers.add(2.);
        numbers.add(1.);
        numbers.add(3.);
        numbers.add(4.);
        numbers.add(5.);
        System.out.println(calculate.sum(numbers));
        System.out.println(calculate.prod(numbers));
    }
}
