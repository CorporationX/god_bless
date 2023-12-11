package faang.school.godbless.lambda.task11school;

import java.util.function.Function;

public class Main {
    // Даны три стороны треугольника, вычислить его площадь
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        Double PerHalf = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2D); // (a + b + c) / 2
        Double PerSubA =sub.apply(PerHalf).apply(a); // p - a
        Double PerSubB =sub.apply(PerHalf).apply(b); // p - b
        Double PerSubC =sub.apply(PerHalf).apply(c); // p -c
        Double MulPerABC = mul.apply(mul.apply(PerSubA).apply(PerSubB)).apply(PerSubC); // (p - a) * (p - b) * (p -c)

        return sqrt.apply(mul.apply(MulPerABC).apply(PerHalf)); // sqrt((p - a) * (p - b) * (p -c) * p)
    }

    public static void main(String[] args) {
        System.out.println(triangleArea(3,4,5));
    }
}
