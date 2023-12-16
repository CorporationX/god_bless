package faang.school.godbless.school;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(6.0, 5.0, 2.2));
    }

    // Даны три стороны треугольника, вычислить его площадь
    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if ((a + b > c) || (a + c > b) || (b + c > a)) {
            throw new IllegalThreadStateException("Сумма двух сторон должна быть больше третей");
        }

        double p = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);

        return sqrt.apply(
                mul.apply(
                        mul.apply(p).apply(
                                mul.apply(
                                        sub.apply(p).apply(a)
                                ).apply(
                                        sub.apply(p)
                                                .apply(b)
                                )
                        )
                ).apply(sub.apply(p).apply(c))
        );
    }
}
