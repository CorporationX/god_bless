package faang.school.godbless;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(3, 5, 7));
        try {
            triangleArea(1, 2, 15);
        } catch (IllegalArgumentException e) {
            System.out.println("неправельный треугольник");
        }
    }

    public static Double triangleArea(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("All lengths of the sides of a triangle must be greater than zero!");
        }

        if (a + b < c || a + c < b || c + b < a) {
            throw new IllegalArgumentException("Two lengths of the sides of a triangle cannot be greater than third!");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double p = div.apply(
                sum.apply(sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);

        return sqrt.apply(
                mul.apply(mul.apply(
                                mul.apply(sub.apply(p).apply(a)).apply(sub.apply(p).apply(b))
                        ).apply(sub.apply(p).apply(c))
                ).apply(p)
        );
    }
}
