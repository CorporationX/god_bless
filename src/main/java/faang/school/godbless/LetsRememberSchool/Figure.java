package faang.school.godbless.LetsRememberSchool;

import java.util.function.Function;

public class Figure {

    // Даны три стороны треугольника, вычислить его площадь
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        if (a == 0 || b == 0 || c == 0) {
            throw new IllegalArgumentException("Side length can't be zero");
        }
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Side length can't be negative");
        }
        double halfOfPerimeter = div.apply(sum.apply(a).apply(sum.apply(b).apply(c))).apply(2.0);
        double area = sqrt.apply(mul.apply(halfOfPerimeter).apply(mul.apply(mul.apply(sub.apply(halfOfPerimeter).apply(c)).apply(sub.apply(halfOfPerimeter).apply(b))).apply(sub.apply(halfOfPerimeter).apply(a))));
        return area;
    }
}