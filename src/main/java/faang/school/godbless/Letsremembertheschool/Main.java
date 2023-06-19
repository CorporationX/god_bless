package faang.school.godbless.Letsremembertheschool;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(3, 4, 5));
    }
        static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("The values must be non-negative or zero");
        }
            Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
            Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
            Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
            Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
            Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

            double halfMeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

            double MeterMinusA = sub.apply(halfMeter).apply(a);
            double MeterMinusB = sub.apply(halfMeter).apply(b);
            double MeterMinusC = sub.apply(halfMeter).apply(c);

            double result = sqrt.apply(mul.apply(mul.apply(mul.apply(halfMeter).apply(MeterMinusA)).apply(MeterMinusB)).apply(MeterMinusC));

            return result;
        }
}
