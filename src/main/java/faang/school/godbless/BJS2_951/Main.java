package faang.school.godbless.BJS2_951;

import java.util.function.Function;

public class Main {
    public static void main(String... args) {
        System.out.println(triangleArea(16, 12, 23));
    }
    public static Double triangleArea (double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if(a>(b+c) || b>(a+c) || c>(a+b)){
            throw new IllegalArgumentException("Triangle inequality");
        }

        double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        double toFormula = mul.apply(mul.apply(mul.apply(p).apply(sub.apply(p).apply(a))).apply(sub.apply(p).apply(b))).apply(sub.apply(p).apply(c));

        return sqrt.apply(toFormula);
    }
}
