package faang.school.godbless.RememberSchool;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Площадь треугольника равна = " + "%.3f",triangleArea(10, 14, 5));
    }

    // Даны три стороны треугольника, вычислить его площадь
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if ((a <= 0 || b <= 0 || c <= 0) || (a + b <= c || b + c <= a || a + c <= b)) {
            throw new IllegalArgumentException("Неверные значения сторон");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double polyPerimeter = div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0);
        double pSubA = sub.apply(polyPerimeter).apply(a);
        double pSubB = sub.apply(polyPerimeter).apply(b);
        double pSubC = sub.apply(polyPerimeter).apply(c);
        double result = sqrt.apply(mul.apply(polyPerimeter).apply(mul.apply(pSubA).apply(mul.apply(pSubB).apply(pSubC))));

        return result;
    }
}
