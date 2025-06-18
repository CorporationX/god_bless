package school.faang.school;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
@Slf4j
public class TriangleAreaCalculator {

    private static final Function<Double, Function<Double, Double>> ADD = x -> y -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = x -> y -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = x -> y -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = x -> y -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    public static Double calculateTriangleArea(double a, double b, double c) {
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
        var sumOfSides = ADD.apply(ADD.apply(a).apply(b)).apply(c);
        var semiPerimeter = DIVIDE.apply(sumOfSides).apply(2d);
        var semiPerimeterMinusSideA = SUBTRACT.apply(semiPerimeter).apply(a);
        var semiPerimeterMinusSideB = SUBTRACT.apply(semiPerimeter).apply(b);
        var semiPerimeterMinusSideC = SUBTRACT.apply(semiPerimeter).apply(c);
        var heronProduct = MULTIPLY.apply(semiPerimeter)
                .apply(MULTIPLY.apply(semiPerimeterMinusSideA)
                        .apply(MULTIPLY.apply(semiPerimeterMinusSideB).apply(semiPerimeterMinusSideC)));
        return SQUARE_ROOT.apply(heronProduct);
    }

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();
        double area = calculator.calculateTriangleArea(3, 4, 5);
        log.info("Площадь треугольника: {}", area);
    }
}
