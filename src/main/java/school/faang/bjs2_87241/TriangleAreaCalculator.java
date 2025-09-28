package school.faang.bjs2_87241;

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

        // Напишите ваш код здесь
        if (a + b > c && a + c > b && b + c > a) {
            double polusumma = DIVIDE.apply(ADD.apply(ADD.apply(a).apply(b)).apply(c)).apply(2.0);
            return SQUARE_ROOT.apply(
                    MULTIPLY.apply(
                            MULTIPLY.apply(
                                    MULTIPLY.apply(polusumma).apply(
                                            SUBTRACT.apply(polusumma).apply(a))).apply(
                                    SUBTRACT.apply(polusumma).apply(b))).apply(
                            SUBTRACT.apply(polusumma).apply(c)));
        }
        return null;
    }
}
