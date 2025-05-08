package school.faang.triangle;

import java.util.function.Function;

public class TriangleAreaCalculator {

    // Лямбда-функции для математических операций
    private static final Function<Double, Function<Double, Double>> ADD = (x) -> (y) -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = (x) -> (y) -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = (x) -> (y) -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = (x) -> (y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    // Метод для вычисления площади треугольника
    public static Double calculateTriangleArea(double a, double b, double c) {
        validate(a, b, c);
        double perimeter = DIVIDE.apply(ADD.apply(ADD.apply(a).apply(b)).apply(c)).apply(2.0);
        return SQUARE_ROOT.apply(MULTIPLY.apply(MULTIPLY.apply(MULTIPLY.apply(perimeter).apply(SUBTRACT.apply(perimeter)
                .apply(a))).apply(SUBTRACT.apply(perimeter).apply(b))).apply(SUBTRACT.apply(perimeter).apply(c)));
    }

    public static void validate(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительны");
        }
        if (!(ADD.apply(a).apply(b) > c && ADD.apply(a).apply(c) > b && ADD.apply(c).apply(b) > a)) {
            throw new IllegalArgumentException("Сумма двух сторон должна быть больше третьей стороны");
        }
    }
}
