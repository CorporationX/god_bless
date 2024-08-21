package BJS2_20626_RememberingSchool;

import java.util.function.Function;

public class Triangle {
    public static void main(String[] args) {
        double a = 5;
        double b = 4;
        double c = 7;

        System.out.println(triangleArea(a, b, c));
    }

    private static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;
        double halfPerimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        double subA = sub.apply(halfPerimeter).apply(a);
        double subB = sub.apply(halfPerimeter).apply(b);
        double subC = sub.apply(halfPerimeter).apply(c);

        double underSqrt = mul.apply(mul.apply(mul
                .apply(halfPerimeter)
                .apply(subA))
                .apply(subB))
                .apply(subC);

        return sqrt.apply(underSqrt);
    }
}
