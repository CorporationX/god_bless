package faang.school.godbless.task.school;

import java.util.function.Function;

public class Triangle {
    public static final String EXCEPTION_MESSAGE = "Invalid size of triangle side";

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if ((a <= 0) || (b <= 0) || (c <= 0)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double p = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);
        double pSubA = sub.apply(p).apply(a);
        double pSubB = sub.apply(p).apply(b);
        double pSubC = sub.apply(p).apply(c);
        return sqrt.apply(
                mul.apply(
                        mul.apply(
                                mul.apply(p).apply(pSubA)
                        ).apply(pSubB)
                ).apply(pSubC)
        );
    }

    public static void main(String[] args) {
        System.out.println(triangleArea(1, 1, 1));
    }
}
