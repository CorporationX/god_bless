package faang.school.godbless.Sprint_3.Lambda.School;

import java.util.function.Function;

public class Application {
    public static Double triangleArea ( double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double halfP = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        double first = sub.apply(halfP).apply(a);
        double second = sub.apply(halfP).apply(b);
        double third = sub.apply(halfP).apply(c);

        System.out.println(halfP);
        System.out.println(first);
        return sqrt.apply(mul.apply(mul.apply(mul.apply(halfP).apply(first)).apply(second)).apply(third));
    }

    public static void main(String... args) {
        System.out.println(triangleArea(3, 4, 5));

    }
}
