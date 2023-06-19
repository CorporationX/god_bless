package faang.school.godbless.schoolRemember;

import java.util.function.Function;

public class Triangle {

    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (a >= sum.apply(b).apply(c) || b >= sum.apply(a).apply(c) || c >= sum.apply(a).apply(b)) {
            throw new IllegalArgumentException("The side of triangle can't be more than sum of two others");
        }

        double halfPerimeter = div.apply(
                        sum.apply(
                                sum.apply(a).apply(b)
                        ).apply(c)).
                apply(2.0);

        double halfPMinA = sub.apply(halfPerimeter).apply(a);
        double halfPMinB = sub.apply(halfPerimeter).apply(b);
        double halfPMinC = sub.apply(halfPerimeter).apply(c);

        return sqrt.apply(
                mul.apply(halfPerimeter).apply(mul.apply(
                        halfPMinA).apply(mul.apply(
                        halfPMinB).apply(halfPMinC))));
    }
}
