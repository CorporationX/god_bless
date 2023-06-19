package faang.school.godbless.school;

import java.util.function.Function;

public class Triangle {
     Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        //полупериметр
        Double ab = sum.apply(a).apply(b);
        Double abc = sum.apply(ab).apply(c);
        Double halfMeter = div.apply(abc).apply(2.0);

        //формула герона
        Double a1 = sub.apply(halfMeter).apply(a);
        Double b1 = sub.apply(halfMeter).apply(b);
        Double c1 = sub.apply(halfMeter).apply(c);

        //сумма первой p и первой скобки
        Double a1sum = mul.apply(halfMeter).apply(a1);
        //сумма остальных двух скобок
        Double b1andC1Sum = mul.apply(b1).apply(c1);


        Double sumABC = mul.apply(a1sum).apply(b1andC1Sum);

        return sqrt.apply(sumABC);
    }

}

