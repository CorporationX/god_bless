package faang.school.godbless.secondsprint.rememberschool;

import java.util.function.Function;

public class TriangleAreaCalculator {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Sides must be positive and non-zero");
        }

        if (sum.apply(a).apply(b) <= c || sum.apply(a).apply(c) <= b || sum.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("The provided sides do not form a valid triangle");
        }

        double semiperimeter = div.apply(sum.apply(a).apply(sum.apply(b).apply(c))).apply(2.0);

        return sqrt.apply(
                mul.apply(semiperimeter).apply(
                        mul.apply(sub.apply(semiperimeter).apply(a)).apply(
                                mul.apply(sub.apply(semiperimeter).apply(b)).apply(sub.apply(semiperimeter).apply(c))
                        )
                )
        );
    }
}
