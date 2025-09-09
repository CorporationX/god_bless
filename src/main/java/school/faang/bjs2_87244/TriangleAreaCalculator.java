package school.faang.bjs2_87244;

import java.util.function.Function;

public class TriangleAreaCalculator {

    // Лямбда-функции для математических операций
    private static final Function<Double, Function<Double, Double>> ADD = (x) -> (y) -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = (x) -> (y) -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = (x) -> (y) -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = (x) -> (y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    public static boolean isValidTriangle(double a, double b, double c) {
        return ADD.apply(a).apply(b) > c
                && ADD.apply(a).apply(c) > b
                && ADD.apply(b).apply(c) > a;
    }

    // Метод для вычисления площади треугольника
    public static Double calculateTriangleArea(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Стороны не образуют треугольник");
        }

        double sum = ADD.apply(ADD.apply(a).apply(b)).apply(c);
        double p = DIVIDE.apply(sum).apply(2.0);

        double pa = SUBTRACT.apply(p).apply(a);
        double pb = SUBTRACT.apply(p).apply(b);
        double pc = SUBTRACT.apply(p).apply(c);

        double product = MULTIPLY.apply(MULTIPLY.apply(MULTIPLY.apply(p).apply(pa)).apply(pb)).apply(pc);

        return SQUARE_ROOT.apply(product);
    }

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();
        double area = calculator.calculateTriangleArea(3, 4, 5);
        System.out.println("Площадь треугольника: " + area);
    }
}