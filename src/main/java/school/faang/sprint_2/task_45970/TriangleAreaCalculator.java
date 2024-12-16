package school.faang.sprint_2.task_45970;

import java.util.function.Function;
import java.util.stream.Stream;

public class TriangleAreaCalculator {

    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = Math::sqrt;

    public Double calculateTriangleArea(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException();
        }
        Double semiPerimeter = divide.apply(
                Stream.of(sideA, sideB, sideC)
                        .reduce(0.0, (acc, side) -> add.apply(acc).apply(side))).apply(2.0);

        return squareRoot.apply(
                Stream.of(sideA, sideB, sideC)
                        .map(side -> subtract.apply(semiPerimeter).apply(side))
                        .reduce(semiPerimeter, (acc, value) -> multiply.apply(acc).apply(value))
        );
    }

    private boolean isValidTriangle(double sideA, double sideB, double sideC) {
        return sideA > 0 && sideB > 0 && sideC > 0
                && sideA < add.apply(sideB).apply(sideC)
                && sideB < add.apply(sideA).apply(sideC)
                && sideC < add.apply(sideA).apply(sideB);
    }

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();

        try {
            double area = calculator.calculateTriangleArea(3, 4, 5);
            System.out.println("Площадь треугольника: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
