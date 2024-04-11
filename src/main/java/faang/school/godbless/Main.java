package faang.school.godbless;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(3, 5, 7));
    }

    public static Double triangleArea(double a, double b, double c) {
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
