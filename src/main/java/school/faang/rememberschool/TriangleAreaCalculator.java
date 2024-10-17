package school.faang.rememberschool;

import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor
public class TriangleAreaCalculator {

    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    // Method to calculate the area of a triangle
    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        // Validate if the given sides can form a triangle
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("The provided sides do not form a valid triangle.");
        }

        // Calculate semi-perimeter s = (a + b + c) / 2
        double s = divide.apply(add.apply(add.apply(a).apply(b)).apply(c)).apply(2.0);

        // Calculate area using Heron's formula: sqrt(s * (s - a) * (s - b) * (s - c))
        double area = squareRoot.apply(
                multiply.apply(s).apply(
                        multiply.apply(subtract.apply(s).apply(a)).apply(
                                multiply.apply(subtract.apply(s).apply(b)).apply(subtract.apply(s).apply(c))
                        )
                )
        );

        return area;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 &&
                add.apply(a).apply(b) > c &&
                add.apply(a).apply(c) > b &&
                add.apply(b).apply(c) > a;
    }

}