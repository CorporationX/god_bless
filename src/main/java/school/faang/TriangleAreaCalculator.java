package school.faang;

import java.util.function.Function;

public class TriangleAreaCalculator {
    private static final Function<Double, Function<Double, Double>> ADD = (x) -> (y) -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = (x) -> (y) -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = (x) -> (y) -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = (x) -> (y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    public static Double calculateTriangleArea(double a, double b, double c) {
        if (ADD.apply(a).apply(b) <= c || ADD.apply(b).apply(c) <= a || ADD.apply(c).apply(a) <= b) {
            throw new IllegalArgumentException(String.format("Triangle with sides %f %f %f don't exists%n", a, b, c));
        }
        double semiPerimeter = DIVIDE.apply(
                ADD.apply(
                        ADD.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);

        double semiPerimeterMinusA = SUBTRACT.apply(semiPerimeter).apply(a);
        double semiPerimeterMinusB = SUBTRACT.apply(semiPerimeter).apply(b);
        double semiPerimeterMinusC = SUBTRACT.apply(semiPerimeter).apply(c);
        double product = MULTIPLY.apply(semiPerimeter)
                .apply(MULTIPLY.apply(semiPerimeterMinusA)
                        .apply(MULTIPLY.apply(semiPerimeterMinusB).apply(semiPerimeterMinusC)));
        return SQUARE_ROOT.apply(product);
    }
}
