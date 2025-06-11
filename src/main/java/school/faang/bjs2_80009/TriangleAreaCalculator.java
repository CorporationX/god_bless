package school.faang.bjs2_80009;

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
        Double p = DIVIDE.apply(
                ADD.apply(a).apply(ADD.apply(b).apply(c))
        ).apply(2.0);
        return SQUARE_ROOT.apply(
                SUBTRACT.apply(p).apply(a) *
                        SUBTRACT.apply(p).apply(b) *
                        SUBTRACT.apply(p).apply(c) * p
        );
    }

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();
        double area = calculator.calculateTriangleArea(3, 4, 111115);
        System.out.println("Площадь треугольника: " + area);
    }

    public static void validate(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a || a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Некорректные стороны треугольника");
        }
    }
}