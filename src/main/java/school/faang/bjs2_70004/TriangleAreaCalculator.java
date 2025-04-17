package school.faang.bjs2_70004;

import java.util.function.Function;

public class TriangleAreaCalculator {
    private static final Function<Double, Function<Double, Double>> ADD = (x) -> (y) -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = (x) -> (y) -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = (x) -> (y) -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = (x) -> (y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    public static Double calculateTriangleArea(double a, double b, double c) {
        validateParams(a, b, c);
        double halfPerimeter = DIVIDE.apply(ADD.apply(ADD.apply(a).apply(b)).apply(c)).apply(2.0);
        double firstMultiple = MULTIPLY.apply(halfPerimeter).apply(SUBTRACT.apply(halfPerimeter).apply(a));
        double secondMultiple = MULTIPLY.apply(firstMultiple).apply(SUBTRACT.apply(halfPerimeter).apply(b));
        double thirdMultiple = MULTIPLY.apply(secondMultiple).apply(SUBTRACT.apply(halfPerimeter).apply(c));
        return SQUARE_ROOT.apply(thirdMultiple);
    }

    private static void validateParams(double a, double b, double c) {
        if (a > ADD.apply(b).apply(c) || b > ADD.apply(a).apply(c) + c || c > ADD.apply(a).apply(b)) {
            throw new IllegalArgumentException("This is not a triangle");
        }
    }
}