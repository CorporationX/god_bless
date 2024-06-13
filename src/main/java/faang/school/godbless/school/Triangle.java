package faang.school.godbless.school;

import java.util.function.Function;

public class Triangle {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        var semiperimeter = div.apply((sub.apply(sum.apply(sum.apply(a).apply(b))
                        .apply(sum.apply(b).apply(c))).apply(b))).apply(2d);

        return sqrt.apply(
                mul.apply(mul.apply(semiperimeter).apply(semiperimeter - a))
                        .apply(mul.apply(semiperimeter - b).apply(semiperimeter - c)));
    }
}
