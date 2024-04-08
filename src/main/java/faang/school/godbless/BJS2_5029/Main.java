package faang.school.godbless.BJS2_5029;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double squareTriangle1 = triangleArea(3, 4, 5);
        System.out.println("SQRT triangle1: " + squareTriangle1);
        double squareTriangle2 = triangleArea(12, 14, 27);
        System.out.println("SQRT triangle2: " + squareTriangle2);
    }
    // Даны три стороны треугольника, вычислить его площадь
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a + b < c || a + c < b || b + c < a) throw new IllegalArgumentException("Такой треугольник не существует");

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double p = mul.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(0.5);

        double sub1 = sub.apply(p).apply(a);
        double sub2 = sub.apply(p).apply(b);
        double sub3 = sub.apply(p).apply(c);

        double mul1 = mul.apply(p).apply(sub1);
        double mul2 = mul.apply(mul1).apply(sub2);
        double mul3 = mul.apply(mul2).apply(sub3);

        return sqrt.apply(mul3);
    }
}