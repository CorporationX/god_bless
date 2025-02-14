package school.faang.backtoschool;

import java.util.function.Function;

public class TriangleAreaCalculator {
    private static final Function<Double, Function<Double, Double>> ADD =
            (firstValue) -> (secondValue) -> firstValue + secondValue;
    private static final Function<Double, Function<Double, Double>> MULTIPLY =
            (firstValue) -> (secondValue) -> firstValue * secondValue;
    private static final Function<Double, Function<Double, Double>> SUBTRACT =
            (firstValue) -> (secondValue) -> firstValue - secondValue;
    private static final Function<Double, Function<Double, Double>> DIVIDE =
            (firstValue) -> (secondValue) -> firstValue / secondValue;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;
    private static final double VALUE_DIVIDE_OF_PERIMETER = 2.0;

    public Double calculateTriangleArea(double sideA, double sideB, double sideC) {
        if (ADD.apply(sideA).apply(sideB) <= sideC
                || ADD.apply(sideB).apply(sideC) <= sideA
                || ADD.apply(sideC).apply(sideA) <= sideB) {
            throw new IllegalArgumentException("Triangle with this sides does not exists");
        }
        double semiPerimeter = calculateTriangleSemiPerimeter(sideA, sideB, sideC);
        double firstParameter = SUBTRACT.apply(semiPerimeter).apply(sideA);
        double secondParameter = SUBTRACT.apply(semiPerimeter).apply(sideB);
        double thirdParameter = SUBTRACT.apply(semiPerimeter).apply(sideC);
        return SQUARE_ROOT.apply(MULTIPLY.apply(MULTIPLY.apply(
                MULTIPLY.apply(firstParameter).apply(secondParameter)).apply(thirdParameter)).apply(semiPerimeter));
    }

    private Double calculateTriangleSemiPerimeter(double sideA, double sideB, double sideC) {
        return DIVIDE.apply(ADD.apply(ADD.apply(sideA).apply(sideB)).apply(sideC)).apply(VALUE_DIVIDE_OF_PERIMETER);
    }
}
