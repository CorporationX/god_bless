package faang.school.godbless.schoolmemo;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Double squareTriangle = triangleArea(2.0, 2.0, 3.0);
        System.out.println(squareTriangle);
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        Double halfPerimeter = div.apply(sum.apply(a).apply(sum.apply(b).apply(c))).apply(2.0);

        Double sub1 = sub.apply(halfPerimeter).apply(a);
        Double sub2 = sub.apply(halfPerimeter).apply(b);
        Double sub3 = sub.apply(halfPerimeter).apply(c);

        return sqrt.apply(mul.apply((mul.apply(mul.apply(halfPerimeter).apply(sub1))).apply(sub2)).apply(sub3));
    }
}
