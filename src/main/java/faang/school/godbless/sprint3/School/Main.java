package faang.school.godbless.sprint3.School;

import java.util.function.Function;

import static java.lang.Double.sum;

public class Main {
    public static void main(String[] args) {
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (a > b + c || b > a + c || c > b + a) {
            throw new IllegalArgumentException("triangle is not exist");
        }

        double abc = sum.apply(sum.apply(a).apply(b)).apply(c);
        double p = div.apply(abc).apply(2.0);
        double first = mul.apply(p).apply(sub.apply(p).apply(a));
        double second = mul.apply(sub.apply(p).apply(b)).apply(sub.apply(p).apply(c));
        return sqrt.apply(mul.apply(first).apply(second));
    }


}
