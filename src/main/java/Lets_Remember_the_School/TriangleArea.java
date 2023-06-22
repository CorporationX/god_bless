package Lets_Remember_the_School;

import java.util.function.Function;

public class TriangleArea {
    public Double triangleArea(double a, double b, double c) throws IllegalArgumentException {

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if ((a + b) <= c || (b + c) <= a || (a + c) <= b) {
            throw new IllegalArgumentException("Такого треугольника не существует");
        }
        double semiPerimeter = div.apply(
                sum.apply(sum.apply(a).apply(b)).apply(c)
        ).apply(2.0);

        Double sPMinusA = sub.apply(semiPerimeter).apply(a);
        Double sPMinusB = sub.apply(semiPerimeter).apply(b);
        Double sPMinusC = sub.apply(semiPerimeter).apply(c);

        Double multiplySPAndMinuses = mul.apply(
                semiPerimeter).apply(mul.apply(sPMinusA).apply(
                mul.apply(sPMinusB).apply(sPMinusC)
        ));

        return sqrt.apply(multiplySPAndMinuses);

    }
}
