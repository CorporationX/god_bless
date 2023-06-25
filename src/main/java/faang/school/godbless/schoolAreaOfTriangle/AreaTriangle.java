package faang.school.godbless.schoolAreaOfTriangle;

import java.util.function.Function;

public class AreaTriangle {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (c > sum.apply(a).apply(b) ||
                b > sum.apply(a).apply(c) ||
                a > sum.apply(b).apply(c)) {
            throw new IllegalArgumentException("There is no such triangle");
        }

        double perimeter = sum.apply(sum.apply(a).apply(b)).apply(c);
        double halfPerimeter = div.apply(perimeter).apply(2.0);

        double pDiv2MinusA = sub.apply(halfPerimeter).apply(a);
        double pDiv2MinusB = sub.apply(halfPerimeter).apply(b);
        double pDiv2MinusC = sub.apply(halfPerimeter).apply(c);

        double tmpMultiple = mul.apply(
                        mul.apply(mul.apply(halfPerimeter).apply(pDiv2MinusA))
                                .apply(pDiv2MinusB))
                .apply(pDiv2MinusC);

        return sqrt.apply(tmpMultiple);
    }
}
