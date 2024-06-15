package faang.school.godbless.lambdas.rememberschool;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(calculateTriangleArea(2, 2, 3));
        try {
            System.out.println(calculateTriangleArea(1, 2, 3));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static Double calculateTriangleArea(double a, double b, double c)
            throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        // validation: a(b/c) + b(c/a) > c(a/b)
        if (sum.apply(a).apply(b) <= c
                || sum.apply(b).apply(c) <= a
                || sum.apply(c).apply(a) <= b) {
            throw new IllegalArgumentException();
        }

        // S = p(p − a)(p − b)(p − c)
        double P = sum.apply(sum.apply(a).apply(b)).apply(c);
        double p = div.apply(P).apply(2d);

        double p_minus_a = sub.apply(p).apply(a);
        double p_minus_b = sub.apply(p).apply(b);
        double p_minus_c = sub.apply(p).apply(c);

        return sqrt.apply(mul
                            .apply(mul
                                    .apply(mul
                                            .apply(p)
                                            .apply(p_minus_a))
                                    .apply(p_minus_b))
                            .apply(p_minus_c));
    }
}
