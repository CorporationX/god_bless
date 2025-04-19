package school.faang.sprint_2.remember_school;

import java.util.function.Function;

public class TriangleAreaCalculator {
    private static final Function<Double, Function<Double, Double>> ADD = (x) -> (y) -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = (x) -> (y) -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = (x) -> (y) -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = (x) -> (y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    public static Double calculateTriangleArea(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Такого треугольника не существует");
        }

        double s = DIVIDE.apply(ADD.apply(ADD.apply(a).apply(b)).apply(c)).apply(2.0);
        return MULTIPLY
                .apply(s).andThen(val1 -> MULTIPLY.apply(val1).apply(s - a))
                .andThen(val2 -> MULTIPLY.apply(val2).apply(s - b))
                .andThen(val3 -> MULTIPLY.apply(val3).apply(s - c))
                .andThen(SQUARE_ROOT).apply(1.0);
    }
}