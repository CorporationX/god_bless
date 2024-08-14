package faang.school.godbless.triangle;

import java.util.function.Function;

public class Main {
    public Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0 ||
                !(a+b>c && a+c>b && b+c>a)) {
            throw new IllegalArgumentException("There is no such triangle");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        Double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2d);//полупериметр

        return sqrt.apply(
                mul.apply(p)
                        .apply(mul.apply(sub.apply(p).apply(a))
                                .apply(mul.apply(sub.apply(p).apply(b))
                                        .apply(sub.apply(p).apply(c))))
        );
    }
}
