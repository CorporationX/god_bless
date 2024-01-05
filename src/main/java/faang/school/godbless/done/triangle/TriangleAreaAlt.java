package faang.school.godbless.done.triangle;

import java.util.function.Function;

public class TriangleAreaAlt {
    public static double getTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        validate(a, b, c);

        // given functions
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double half = 2.0;
        double halfP;
        double result;

        // get perimeter half
        halfP = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(half);

        // get square
        result = sqrt.apply(
            mul.apply(halfP)
                .apply(
                    mul.apply(
                        sub.apply(halfP).apply(a))
                        .apply(
                            mul.apply(
                                sub.apply(halfP).apply(b))
                                .apply(sub.apply(halfP).apply(c))
                        )
                )
        );

        System.out.println(result);
        return result;
    }

    private  static void validate (double a, double b, double c) throws IllegalArgumentException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Invalid arguments");
        }
    }
}
