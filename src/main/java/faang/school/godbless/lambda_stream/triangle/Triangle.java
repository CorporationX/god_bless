package faang.school.godbless.lambda_stream.triangle;

import java.util.function.Function;

public class Triangle {
    public static Double triangleArea(double a, double b, double c) {
        validation(a, b, c);
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double halfPerimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        double deltaA = sub.apply(halfPerimeter).apply(a);
        double deltaB = sub.apply(halfPerimeter).apply(b);
        double deltaC = sub.apply(halfPerimeter).apply(c);
        double heron = mul.apply(halfPerimeter).apply(mul.apply(mul.apply(deltaA).apply(deltaB)).apply(deltaC));
        return sqrt.apply(heron);
    }

    private static void validation(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Illegal argument");
        }
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("Impossible triangle");
        }
    }
}
