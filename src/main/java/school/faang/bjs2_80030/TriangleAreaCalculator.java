package school.faang.bjs2_80030;

import java.util.function.Function;

public class TriangleAreaCalculator {

    private static final Function<Double, Function<Double, Double>> ADD = x -> y -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = x -> y -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = x -> y -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = x -> y -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    public static Double calculateTriangleArea(double a, double b, double c) {
        if (ADD.apply(a).apply(b) <= c
            || ADD.apply(a).apply(c) <= b
            || ADD.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Некорректные стороны треугольника.");
        }

        double sumAb = ADD.apply(a).apply(b);
        double sumAbc = ADD.apply(sumAb).apply(c);
        double s = DIVIDE.apply(sumAbc).apply(2.0);

        double sa = SUBTRACT.apply(s).apply(a);
        double sb = SUBTRACT.apply(s).apply(b);
        double sc = SUBTRACT.apply(s).apply(c);

        double areaSquared = MULTIPLY
                .apply(MULTIPLY.apply(MULTIPLY.apply(s).apply(sa)).apply(sb))
                .apply(sc);

        return SQUARE_ROOT.apply(areaSquared);
    }

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();
        double area = calculator.calculateTriangleArea(9, 7, 11);
        System.out.printf("Площадь треугольника: %.2f%n", area);
    }
}