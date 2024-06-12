package faang.school.godbless.lambda;

import java.util.function.Function;

public class Main {

    public static Double triangleSquare(Double a, Double b, Double c) {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        if (!isTriangle(a, b, c)) {
            throw new IllegalArgumentException("Not a triangle, a = " + a + ", b = " + b + ", c = " + c);
        }

        Double halfPerimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        Double subA = sub.apply(halfPerimeter).apply(a);
        Double subB = sub.apply(halfPerimeter).apply(b);
        Double subC = sub.apply(halfPerimeter).apply(c);

        Double fullMul = mul.apply(mul.apply(mul.apply(halfPerimeter).apply(subA)).apply(subB)).apply(subC);
        return sqrt.apply(fullMul);
    }

    private static boolean isTriangle(Double a, Double b, Double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static void main(String[] args) {
        System.out.println(triangleSquare(3.0, 4.0, 7.0));
    }
}
