package faang.school.godbless.lambda.school;

import java.util.function.Function;

public class Geometry {

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Sides of a triangle must be positive");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Triangle sides do not form a valid triangle");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double halfPerimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        double halfPerimeterWithoutA = sub.apply(halfPerimeter).apply(a);
        double halfPerimeterWithoutB = sub.apply(halfPerimeter).apply(b);
        double halfPerimeterWithoutC = sub.apply(halfPerimeter).apply(c);


        return sqrt.apply(
                mul.apply(mul.apply(mul.apply(halfPerimeter)
                                        .apply(halfPerimeterWithoutA))
                                .apply(halfPerimeterWithoutB))
                        .apply(halfPerimeterWithoutC));
    }
}
