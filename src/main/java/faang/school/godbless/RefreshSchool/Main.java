package faang.school.godbless.RefreshSchool;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(3, 4, 5));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        isValid(a, b, c);

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        double sub1 = sub.apply(p).apply(a);
        double sub2 = sub.apply(p).apply(b);
        double sub3 = sub.apply(p).apply(c);

        double mul1 = mul.apply(p).apply(sub1);
        double mul2 = mul.apply(mul1).apply(sub2);
        double mul3 = mul.apply(mul2).apply(sub3);

        return sqrt.apply(mul3);
    }

    private static void isValid(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Сторона не может иметь отрицательное значение");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Треугольника с такими сторонами не существует");
        }
    }
}
