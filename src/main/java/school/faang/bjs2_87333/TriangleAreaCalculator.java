package school.faang.bjs2_87333;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TriangleAreaCalculator {
    private static final BiFunction<Double, Double, Double> ADD = Double::sum;
    private static final BiFunction<Double, Double, Double> MULTIPLY = (x, y) -> x * y;
    private static final BiFunction<Double, Double, Double> SUBTRACT = (x, y) -> x - y;
    private static final BiFunction<Double, Double, Double> DIVIDE = (x, y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    public static Double calculateTriangleArea(double a, double b, double c) {
        validateTriangle(a, b, c);

        double semiPerimeter = DIVIDE.apply(ADD.apply(ADD.apply(a, b), c), 2.0);

        return SQUARE_ROOT.apply(
                MULTIPLY.apply(
                        MULTIPLY.apply(
                                semiPerimeter,
                                SUBTRACT.apply(semiPerimeter, a)
                        ),
                        MULTIPLY.apply(
                                SUBTRACT.apply(semiPerimeter, b),
                                SUBTRACT.apply(semiPerimeter, c)
                        )
                )
        );
    }

    private static void validateTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны должны быть положительными.");
        }

        double max = Math.max(a, Math.max(b, c));
        double sum = a + b + c;
        if (sum - max <= max) {
            throw new IllegalArgumentException("Нарушено неравенство треугольника.");
        }
    }
}
