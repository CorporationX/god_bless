package faang.school.godbless.backtoschool;

import java.util.function.Function;

public class AreaCalculator {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Sides must be positive");
        }
        if (sum.apply(a).apply(b) <= c || sum.apply(b).apply(c) <= a || sum.apply(a).apply(c) <= b) {
            throw new IllegalArgumentException("Invalid side lengths for a triangle");
        }

        // p = (a + b + c) / 2
        double aPlusB = sum.apply(a).apply(b);
        double perimeter = sum.apply(aPlusB).apply(c);
        double halfPerimeter = div.apply(perimeter).apply(2.0);

        double subA = sub.apply(halfPerimeter).apply(a);
        double subB = sub.apply(halfPerimeter).apply(b);
        double subC = sub.apply(halfPerimeter).apply(c);

        double first = mul.apply(halfPerimeter).apply(subA);
        double second = mul.apply(first).apply(subB);
        double third = mul.apply(second).apply(subC);

        return sqrt.apply(third);
    }
}
