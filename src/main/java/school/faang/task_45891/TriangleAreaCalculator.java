package school.faang.task_45891;

import java.util.function.Function;
import java.util.stream.Stream;

public class TriangleAreaCalculator {
    private static final Function<Double, Function<Double, Double>> ADD = (x) -> (y) -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = (x) -> (y) -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = (x) -> (y) -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = (x) -> (y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        final double aPlusB = ADD.apply(a).apply(b);

        if (aPlusB <= c || ADD.apply(a).apply(c) <= b || ADD.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }

        final double perimeter = ADD.apply(aPlusB).apply(c);
        final double semiPerimeter = DIVIDE.apply(perimeter).apply(2.0);

        final double semiPerimeterMinusSideA = SUBTRACT.apply(semiPerimeter).apply(a);
        final double semiPerimeterMinusSideB = SUBTRACT.apply(semiPerimeter).apply(b);
        final double semiPerimeterMinusSideC = SUBTRACT.apply(semiPerimeter).apply(c);

        final double squaredArea = Stream.of(
                        semiPerimeter,
                        semiPerimeterMinusSideA,
                        semiPerimeterMinusSideB,
                        semiPerimeterMinusSideC
                ).reduce((x1, x2) -> MULTIPLY.apply(x1).apply(x2))
                .orElseThrow(() -> new ArithmeticException("Cannot calculate triangle area: invalid values"));

        return SQUARE_ROOT.apply(squaredArea);
    }

}
