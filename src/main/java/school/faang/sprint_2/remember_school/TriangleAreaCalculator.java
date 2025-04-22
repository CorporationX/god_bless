package school.faang.sprint_2.remember_school;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TriangleAreaCalculator {
    private static final BiFunction<Double, Double, Double> ADD = Double::sum;
    private static final BiFunction<Double, Double, Double> MULTIPLY = (x, y) -> x * y;
    private static final BiFunction<Double, Double, Double> SUBTRACT = (x, y) -> x - y;
    private static final BiFunction<Double, Double, Double> DIVIDE = (x, y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    public static Double calculateTriangleArea(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Такого треугольника не существует");
        }

        double s = DIVIDE.apply(ADD.apply(ADD.apply(a, b), c), 2.0);
        return SQUARE_ROOT.apply(MULTIPLY.apply(MULTIPLY.apply(MULTIPLY.apply(s, s - a), s - b), s - c));
    }
}