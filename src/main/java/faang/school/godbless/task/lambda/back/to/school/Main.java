package faang.school.godbless.task.lambda.back.to.school;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double a = 2, b = 2, c = 2;
        double S = triangleArea(a, b, c);
        System.out.println("Площадь треугольника с сторонами %s, %s, %s равна: %s"
                .formatted(a, b, c, S));
    }

    // Даны три стороны треугольника, вычислить его площадь
    public static Double triangleArea(double a, double b, double c)
            throws IllegalArgumentException {
        if (a == 0 || b == 0 || c == 0) {
            throw new IllegalArgumentException(
                    "Входные значения не могут быть меньше или равны нулю.");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        // Полупериметр p = (a + c + b) / 2
        Double p = sum.apply(sum.apply(a).apply(b)).apply(c) / 2;

        // pa = (p - a); pb = (p - b); pc = (p - c);
        Double pa = sub.apply(p).apply(a);
        Double pb = sub.apply(p).apply(b);
        Double pc = sub.apply(p).apply(c);

        // Произведение для квадратного корня
        // P = p * (p - a) * (p - b) * (p - c)
        Double P = mul.apply(mul.apply(p).apply(pa)).apply(mul.apply(pb).apply(pc));

        return sqrt.apply(P);
    }
}
