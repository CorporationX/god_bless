package school.faang.task_45891;

import java.util.function.Function;
import java.util.stream.Stream;

public class TriangleAreaCalculator {
    private static final Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    private static final Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    private static final Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    private static final Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    private static final Function<Double, Double> squareRoot = Math::sqrt;

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (add.apply(a).apply(b) <= c || add.apply(a).apply(c) <= b || add.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не может существовать");
        }

        double perimeter = add.apply(add.apply(a).apply(b)).apply(c);
        double semiPerimeter = divide.apply(perimeter).apply(2.0);

        double semiPerimeterMinusSideA = subtract.apply(semiPerimeter).apply(a);
        double semiPerimeterMinusSideB = subtract.apply(semiPerimeter).apply(b);
        double semiPerimeterMinusSideC = subtract.apply(semiPerimeter).apply(c);

        return squareRoot.apply(
                Stream.of(
                        semiPerimeter,
                        semiPerimeterMinusSideA,
                        semiPerimeterMinusSideB,
                        semiPerimeterMinusSideC
                ).reduce((x1, x2) -> multiply.apply(x1).apply(x2)).orElseThrow()
        );
    }

}
