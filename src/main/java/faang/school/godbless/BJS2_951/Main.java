package faang.school.godbless.BJS2_951;

import java.util.function.Function;

public class Main {
    public static void main(String... args) {
        System.out.println(triangleArea(16, 12, 23));
    }
    public static Double triangleArea (double a, double b, double c) throws IllegalArgumentException {
        if(a>(b+c) || b>(a+c) || c>(a+b)){
            throw new IllegalArgumentException("Triangle inequality");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        double pMinusA = sub.apply(p).apply(a);
        double pMinusB = sub.apply(p).apply(b);
        double pMinusC = sub.apply(p).apply(c);
        double firstHalf = mul.apply((mul.apply(p).apply(pMinusB))).apply(pMinusC);
        double secondHalf = mul.apply(firstHalf).apply(pMinusA);

        return sqrt.apply(secondHalf);
    }
}
