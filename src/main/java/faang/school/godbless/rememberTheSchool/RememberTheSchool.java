package faang.school.godbless.rememberTheSchool;

import java.util.function.Function;

public class RememberTheSchool {
    // Даны три стороны треугольника, вычислить его площадь
    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Треугольник с данными сторонами не существует!");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double semiPerimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        double deltaA = sub.apply(semiPerimeter).apply(a);
        double deltaB = sub.apply(semiPerimeter).apply(b);
        double deltaC = sub.apply(semiPerimeter).apply(c);
        double radicalExpression = mul.apply(semiPerimeter).apply(mul.apply(deltaA).apply(mul.apply(deltaB).apply(deltaC)));
        return sqrt.apply(radicalExpression);
    }
}
