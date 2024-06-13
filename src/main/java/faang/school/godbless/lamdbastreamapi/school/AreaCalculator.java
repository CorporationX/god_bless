package faang.school.godbless.lamdbastreamapi.school;

import java.util.function.Function;


public class AreaCalculator {

    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {

        if (a <= 0.0 || b <= 0.0 || c <= 0.0) {
            throw new IllegalArgumentException("Введено неположительное значение стороны треугольника");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> (y) -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> (y) -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> (y) -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> (y) -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        Double fullP = sum.apply(sum.apply(a).apply(b)).apply(c);
        Double p = div.apply(fullP).apply(2.0);
        Double pSubA = sub.apply(p).apply(a);
        Double pSubB = sub.apply(p).apply(b);
        Double pSubC = sub.apply(p).apply(c);
        Double composition = mul.apply(mul.apply(mul.apply(p).apply(pSubA)).apply(pSubB)).apply(pSubC);
        return sqrt.apply(composition);
    }
}
