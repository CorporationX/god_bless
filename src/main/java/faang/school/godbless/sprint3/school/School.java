package faang.school.godbless.sprint3.school;

import java.util.function.Function;

public class School {
    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a == 0 || b == 0 || c == 0) {
            throw new IllegalArgumentException("Sides of a triangle cannot be zero");
        }
        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new IllegalArgumentException("Invalid input data");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double pDiv2 = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);
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
}
