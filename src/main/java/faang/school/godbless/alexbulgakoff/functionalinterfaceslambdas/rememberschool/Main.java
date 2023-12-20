package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.rememberschool;

import java.util.function.Function;

/**
 * @author Alexander Bulgakov
 */

public class Main {

    public static void main(String[] args) {
        double a = 10.0;
        double b = 15.0;
        double c = 20.0;

        System.out.println(triangleArea(a, b, c));
    }
    //S = √(p * (p — a) * (p — b) * (p — c))
    //p = (a + b + c) / 2

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double p = div.apply(
                sum.apply(sum.apply(a).apply(b)).apply(c))
                .apply(2.0);

        return sqrt.apply(mul.apply(mul.apply(mul.apply(p).apply(sub.apply(p).apply(a))).apply(sub.apply(p).apply(b))).apply(sub.apply(p).apply(c)));
    }

}
