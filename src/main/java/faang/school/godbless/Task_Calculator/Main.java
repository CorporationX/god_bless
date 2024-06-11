package faang.school.godbless.Task_Calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static double calculate(List<Double> numbers, Calculator calculator) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        } else {
            double res = numbers.get(0);
           for (int i = 1; i<numbers.size(); i++) {
               res = calculator.calculate(res, numbers.get(i));
           }
            return res;
        }
    }

    public static double sum(List<Double> numbers) {
        return calculate(numbers, (a, b) ->a+b);
    }

    public static double prod(List<Double> numbers) {
        return calculate(numbers, (a,b)->a*b);
    }

    public static void main(String[] args) {

        List<Double> numbers = new ArrayList<>();
        numbers.add(2.);
        numbers.add(1.);
        numbers.add(3.);
        numbers.add(4.);
        numbers.add(5.);
        System.out.println(sum(numbers));
        System.out.println(prod(numbers));
    }
}
