package faang.school.godbless.RememberSchool;

import lombok.NonNull;

import java.util.function.Function;

public class Area {
    private Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    private Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
    private Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
    private Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
    private Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

    Double triangleArea(@NonNull double a, @NonNull double b, @NonNull double c) throws IllegalArgumentException {
        if (a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a)) {
            return calculateArea(a, b, c);
        }
        throw new IllegalArgumentException("Ошибочные значения");
    }

    private double calculateArea(double a, double b, double c) {
        double pDiv2 = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);
        return sqrt.apply(
                mul.apply(pDiv2).apply(
                        mul.apply(
                                mul.apply(sub.apply(pDiv2).apply(a))
                                        .apply(sub.apply(pDiv2).apply(b))
                        ).apply(sub.apply(pDiv2).apply(c))));
    }
}
