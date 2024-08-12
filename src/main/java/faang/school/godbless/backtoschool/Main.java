package faang.school.godbless.backtoschool;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Double area = triangleArea(3.0, 4.0, 5.0);
        System.out.printf("Площадь треугольника: %s", area);
    }

    // Даны три стороны треугольника, вычислить его площадь
    private static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double halfPerimeter = div.apply(sum.apply(
                sum.apply(a).apply(b)
        ).apply(c)).apply(2.0);

        double subA = sub.apply(halfPerimeter).apply(a);
        double subB = sub.apply(halfPerimeter).apply(b);
        double subC = sub.apply(halfPerimeter).apply(c);

        return sqrt.apply(mul.apply(mul.apply(mul.apply(
                                        halfPerimeter)
                                .apply(subA))
                        .apply(subB))
                .apply(subC));
    }
}