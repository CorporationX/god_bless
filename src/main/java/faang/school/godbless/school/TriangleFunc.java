package faang.school.godbless.school;

import java.util.function.Function;

public class TriangleFunc {
    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        Double polyPerimetr = div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2d);
        Double perMinusA = sub.apply(polyPerimetr).apply(a);
        Double perMinusB = sub.apply(polyPerimetr).apply(b);
        Double perMinusC = sub.apply(polyPerimetr).apply(c);

        return sqrt.apply(mul.apply(polyPerimetr).apply((mul.apply(perMinusA)).apply(mul.apply(perMinusB).apply(perMinusC))));
    }

}


