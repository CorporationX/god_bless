package faang.school.godbless.BJS2_20466;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double a = 3;
        double b = 4;
        double c = 5;

        try {
            Double area = triangleArea(a, b, c);
            System.out.println("Площадь треугольника: " + area);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("The sides of the triangle must be greater than 0");
        }

        if (!(a + b > c) || !(a + c > b) || !(b + c > a)) {
            throw new IllegalArgumentException("The wrong sides of the triangle");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        Double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.00);
        return sqrt.apply(mul.apply(mul.apply(mul.apply(p).apply(sub.apply(p).apply(a))).apply(sub.apply(p).apply(b))).apply(sub.apply(p).apply(c)));
    }
}
