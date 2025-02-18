package school.faang.BJS2_57295;

import java.util.function.Function;

public class TriangleAreaCalculator {
    private static final Function<Double, Function<Double, Double>> ADD = (x) -> (y) -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = (x) -> (y) -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = (x) -> (y) -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = (x) -> (y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;
    private static final double HALF = 2.0;

    public static Double calculateTriangleArea(double a, double b, double c) {
        double sum = ADD.apply(a).apply(ADD.apply(b).apply(c));
        double halfPerimeter = DIVIDE.apply(sum).apply(HALF);

        double differenceA = SUBTRACT.apply(halfPerimeter).apply(a);
        double differenceB = SUBTRACT.apply(halfPerimeter).apply(b);
        double differenceC = SUBTRACT.apply(halfPerimeter).apply(c);

        double productOfDifferences = MULTIPLY.apply(halfPerimeter)
                .apply(MULTIPLY.apply(differenceA).apply(MULTIPLY.apply(differenceB).apply(differenceC)));

        return SQUARE_ROOT.apply(productOfDifferences);
    }

}
