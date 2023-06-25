package faang.school.godbless.triangle;

import java.util.function.Function;

public class Triangle {

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        validate(a, b, c);

        // semi-perimeter [p = (a + b + c) / 2]
        double pDiv2 = div.apply(
            sum.apply(
                sum.apply(a).apply(b)
            ).apply(c))
            .apply(2.0);


        // Heron's formula [S = √s(s - a)(s - b)(s - c)]
        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);

        return sqrt.apply(
            mul.apply(
                mul.apply(pDiv2).apply(pDiv2MinusA)
            ).apply(
                mul.apply(pDiv2MinusB).apply(pDiv2MinusC)
            )
        );
    }

    private static void validate(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Must be positive numbers");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
    }
}
