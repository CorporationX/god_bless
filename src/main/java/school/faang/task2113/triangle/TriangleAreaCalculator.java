package school.faang.task2113.triangle;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a > add.apply(b).apply(c) || c > add.apply(a).apply(b) || b > add.apply(c).apply(a)) {
            throw new IllegalArgumentException();
        }
        double halfPerimeter = divide.apply(add.apply(a).apply(add.apply(b).apply(c))).apply(2.0);
        double result = squareRoot.apply(
                multiply.apply(
                                multiply.apply(
                                                multiply.apply(halfPerimeter)
                                                        .apply(subtract.apply(halfPerimeter).apply(a)))
                                        .apply(subtract.apply(halfPerimeter).apply(b))).
                        apply(subtract.apply(halfPerimeter).apply(c))
        );
        return result;
    }
}
