package school.faang.sprint_2.task_45970;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public class TriangleAreaCalculator {

    BiFunction<Double, Double, Double> add = Double::sum;
    BiFunction<Double, Double, Double> multiply = (x, y) -> x * y;
    BiFunction<Double, Double, Double> subtract = (x, y) -> x - y;
    BiFunction<Double, Double, Double> divide = (x, y) -> x / y;

    public Double calculateTriangleArea(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException();
        }
        Double semiPerimeter = divide.apply(
                Stream.of(sideA, sideB, sideC)
                        .reduce(0.0, add::apply), 2.0);

        return Math.sqrt(
                Stream.of(sideA, sideB, sideC)
                        .map(side -> subtract.apply(semiPerimeter, side))
                        .reduce(semiPerimeter, multiply::apply)
        );
    }

    private boolean isValidTriangle(double sideA, double sideB, double sideC) {
        return sideA > 0 && sideB > 0 && sideC > 0
                && sideA < add.apply(sideB, sideC)
                && sideB < add.apply(sideA, sideC)
                && sideC < add.apply(sideA, sideB);
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
