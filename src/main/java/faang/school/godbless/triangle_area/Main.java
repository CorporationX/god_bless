package faang.school.godbless.triangle_area;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println("Triangle area: " + triangleArea(7, 8, 9));
    }

    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        if (!(a + b >= c && b + c >= a && c + a >= b)) {
            throw new IllegalArgumentException("Sides should satisfy the triangle inequality: (a+b) >= c AND (b+c) >= a (c+a) >= b");
        }

        double p = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);

        return sqrt.apply(
                sub.apply(
                        mul.apply(
                                mul.apply(
                                        sub.apply(p).apply(b)
                                ).apply(
                                        sub.apply(p).apply(c)
                                )
                        ).apply(
                                sub.apply(p).apply(a)
                        )
                ).apply(p)
        );
    }
}
