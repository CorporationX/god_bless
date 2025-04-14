package school.faang.remember_school;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TriangleSquareCalculator {
    private static final BiFunction<Double, Double, Double> ADD = Double::sum;
    private static final BiFunction<Double, Double, Double> SUBTRACT = (a, b) -> a - b;
    private static final BiFunction<Double, Double, Double> MULTIPLY = (a, b) -> a * b;
    private static final BiFunction<Double, Double, Double> DIVIDE = (a, b) -> a / b;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;


    public static Double calculateTriangleArea(double a, double b, double c) {
        validateIfTriangle(a, b, c);
        double halfPerimeter = DIVIDE.apply(ADD.apply(a, ADD.apply(b, c)), 2.0);
        double halfPerimeterSubtractA = SUBTRACT.apply(halfPerimeter, a);
        double halfPerimeterSubtractB = SUBTRACT.apply(halfPerimeter, b);
        double halfPerimeterSubtractC = SUBTRACT.apply(halfPerimeter, c);
        return SQUARE_ROOT.apply(MULTIPLY.apply(halfPerimeter, MULTIPLY.apply(halfPerimeterSubtractA,
                MULTIPLY.apply(halfPerimeterSubtractB, halfPerimeterSubtractC))));
    }

    private static void validateIfTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new RuntimeException("Value cannot be less than zero");
        }
        double comparisonWithA = ADD.apply(b, c);
        double comparisonWithB = ADD.apply(a, c);
        double comparisonWithC = ADD.apply(a, b);
        if (comparisonWithA <= a || comparisonWithB <= b || comparisonWithC <= c) {
            throw new RuntimeException("This is not a triangle!");
        }
    }
}
