package faang.school.godbless.Lets.remember.the.school;

import java.util.function.Function;

public class AreaCalculator {
    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (a == 0 || b == 0 || c == 0) {
            throw new IllegalArgumentException("Такого треугольника не существует");
        } else if (a + b <= c || a + c <= b || c + b <= a){
            throw new IllegalArgumentException("Такого треугольника не существует");
        }

            Double area;

        Double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        Double pSubA = sub.apply(p).apply(a);
        Double pSubB = sub.apply(p).apply(b);
        Double pSubC = sub.apply(p).apply(c);

        area = sqrt.apply(mul.apply(p).apply(mul.apply(pSubA).apply(mul.apply(pSubB).apply(pSubC))));

        return area;
    }

}
