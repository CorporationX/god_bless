package BJS2_9087;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws TriangleException {
        double a = 3;
        double b = 4;
        double c = 5;

        if (a + b > c && b + c > a && a + c > b) {
            System.out.println(triangleArea(a, b, c));
        } else
            throw new TriangleException("Triangle doesnt exist");
    }

    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        //S = √(p * (p - a) * (p - b) * (p - c))

        double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        double mult1 = mul.apply(p).apply(sub.apply(p).apply(a));
        double mult2 = mul.apply(mult1).apply(sub.apply(p).apply(b));
        double mult3 = mul.apply(mult2).apply(sub.apply(p).apply(c));

        double result = sqrt.apply(mult3);

        return result;
    }
}