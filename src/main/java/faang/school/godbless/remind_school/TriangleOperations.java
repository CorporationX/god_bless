package faang.school.godbless.remind_school;

import java.util.function.Function;

public class TriangleOperations {
    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Side of triangle cannot be negative");
        }
        double perimeter = sum.apply(sum.apply(a).apply(b)).apply(c);
        double halfPerimeter = div.apply(perimeter)
                .apply(2.0);
        double p2MinusA = sub.apply(halfPerimeter).apply(a);
        double p2MinusB = sub.apply(halfPerimeter).apply(b);
        double p2MinusC = sub.apply(halfPerimeter).apply(c);
        return sqrt.apply(
                mul.apply(mul.apply(p2MinusA)
                                .apply(p2MinusB))
                   .apply(mul.apply(p2MinusC)
                           .apply(halfPerimeter))
        );
    }
}
