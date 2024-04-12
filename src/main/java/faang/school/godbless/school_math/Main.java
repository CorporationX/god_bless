package faang.school.godbless.school_math;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        double a = 5.0;
        double b = 6.0;
        double c = 7.0;

        double result = triangleArea(a, b, c);
        System.out.println(result);
    }

    private static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        Double semiperimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        Double sumOfAllSides = sum.apply(sum.apply(a).apply(b)).apply(c);

        return sqrt.apply(mul.apply(semiperimeter).apply(sumOfAllSides));
    }
}