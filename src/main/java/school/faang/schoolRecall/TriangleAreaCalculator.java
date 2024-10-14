package school.faang.schoolRecall;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = Math::sqrt;

    // Метод для вычисления площади треугольника
    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (add.apply(a).apply(b) <= c || add.apply(b).apply(c) <= a || add.apply(a).apply(c) <= b) {
            throw new IllegalArgumentException("This is not a triangle");
        } else {
            double p = divide.apply(add.apply(a).apply(add.apply(b).apply(c))).apply(2.0);
            return squareRoot.apply(multiply.apply(multiply.apply(
                    multiply.apply(p).apply(subtract.apply(p).apply(a)))
                    .apply(subtract.apply(p).apply(b)))
                    .apply(subtract.apply(p).apply(c)));
        }
    }
}
