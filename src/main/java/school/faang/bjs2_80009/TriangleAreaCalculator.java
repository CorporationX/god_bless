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
        Double semiPerimeter = DIVIDE.apply(
                ADD.apply(a).apply(ADD.apply(b).apply(c))
        ).apply(2.0);
        double semiPerimeterMinusA = SUBTRACT.apply(semiPerimeter).apply(a);
        double semiPerimeterMinusB = SUBTRACT.apply(semiPerimeter).apply(b);
        double semiPerimeterMinusC = SUBTRACT.apply(semiPerimeter).apply(c);
        return SQUARE_ROOT.apply(
                MULTIPLY.apply(semiPerimeterMinusA).apply(MULTIPLY.apply(semiPerimeterMinusB)
                        .apply(MULTIPLY.apply(semiPerimeterMinusC).apply(semiPerimeter))
                )
        );
    }

    public static void main(String[] args) {
        double area = calculateTriangleArea(3, 4, 5);
        System.out.println("Площадь треугольника: " + area);
    }

    private static void validate(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a || a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Некорректные стороны треугольника");
        }
    }
}