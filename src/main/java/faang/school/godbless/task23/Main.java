package faang.school.godbless.task23;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double p = (double) (4 + 3 + 6) / 2;
        double test = Math.sqrt(p * (p - 4) * (p - 3) * (p - 6));

        System.out.println(test);
        System.out.println(triangleArea(4, 3, 6));
    }

    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        return sqrt.apply(mul.apply(p).apply(mul.apply(sub.apply(p).apply(c)).apply(mul.apply(sub.apply(p).apply(a)).apply(sub.apply(p).apply(b)))));
    }
}
