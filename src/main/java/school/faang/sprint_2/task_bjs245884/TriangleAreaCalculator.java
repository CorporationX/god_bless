package school.faang.sprint_2.task_bjs245884;

import java.util.function.Function;

public class TriangleAreaCalculator {

    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = Math::sqrt;

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();

        try {
            double area = calculator.calculateTriangleArea(3, 4, 5);
            System.out.println("Площадь треугольника: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public Double calculateTriangleArea(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (sideA >= add.apply(sideB).apply(sideC)
                || sideB >= add.apply(sideA).apply(sideC)
                || sideC >= add.apply(sideA).apply(sideB)
        ) {
            throw new IllegalArgumentException("Невозможно создать треугольник с указанными сторонами");
        }

        double halfPerimeter = divide.apply(
                add.apply(sideA).apply(
                        add.apply(sideB).apply(sideC)
                )
        ).apply(2.0);
        double perimeterMinusSideA = subtract.apply(halfPerimeter).apply(sideA);
        double perimeterMinusSideB = subtract.apply(halfPerimeter).apply(sideB);
        double perimeterMinusSideC = subtract.apply(halfPerimeter).apply(sideC);
        return squareRoot.apply(
                multiply.apply(halfPerimeter).apply(
                        multiply.apply(perimeterMinusSideA).apply(
                                multiply.apply(perimeterMinusSideB).apply(perimeterMinusSideC)
                        )
                )
        );
    }
}