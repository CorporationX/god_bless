package school.faang.bjs2_71572;

import java.util.function.Function;

public class TriangleAreaCalculator {
    private static final Function<Double, Function<Double, Double>> ADD = (x) -> (y) -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = (x) -> (y) -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = (x) -> (y) -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = (x) -> (y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    public static Double calculateTriangleArea(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть полоджительными!");
        }

        boolean isTriangleExists = ADD.apply(a).apply(b) > c
                && ADD.apply(a).apply(c) > b
                && ADD.apply(b).apply(c) > a;
        if (!isTriangleExists) {
            throw new IllegalArgumentException("Треугольник с заданными сторонами не существует!");
        }

        double p = DIVIDE.apply(ADD.apply(ADD.apply(a).apply(b)).apply(c)).apply(2.0);
        return SQUARE_ROOT.apply(
                MULTIPLY.apply(p).apply(
                        MULTIPLY.apply(SUBTRACT.apply(p).apply(a)).apply(
                                MULTIPLY.apply(SUBTRACT.apply(p).apply(b)).apply(
                                        SUBTRACT.apply(p).apply(c)
                                ))));
    }
}
