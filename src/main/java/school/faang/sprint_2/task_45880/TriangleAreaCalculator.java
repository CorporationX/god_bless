package school.faang.sprint_2.task_45880;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();

        try {
            double area = calculator.calculateTriangleArea(3, 4, 5);
            System.out.println("Площадь треугольника: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public double calculateTriangleArea(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (!isValidTriangleSides(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Неверные стороны треугольника");
        }

        double semiPerimeter = calculateSemiPerimeter(sideA, sideB, sideC);
        double productOfDeltaValues = calculateDeltaValuesProduct(semiPerimeter, sideA, sideB, sideC);
        double triangleArea = squareRoot.apply(multiply.apply(semiPerimeter).apply(productOfDeltaValues));

        return triangleArea;
    }

    private boolean isValidTriangleSides(double sideA, double sideB, double sideC) {
        return sideA >= 0 && sideB >= 0 && sideC >= 0
                && add.apply(sideA).apply(sideB) <= sideC
                && add.apply(sideA).apply(sideC) <= sideB
                && add.apply(sideB).apply(sideC) <= sideA;
    }

    private double calculateSemiPerimeter(double sideA, double sideB, double sideC) {
        Double perimeter = add.apply(
                add.apply(sideA).apply(sideB)
        ).apply(sideC);

        return divide.apply(perimeter).apply(2.0);
    }

    private double calculateDeltaValuesProduct(double semiPerimeter, double sideA, double sideB, double sideC) {
        Double deltaA = subtract.apply(semiPerimeter).apply(sideA);
        Double deltaB = subtract.apply(semiPerimeter).apply(sideB);
        Double deltaC = subtract.apply(semiPerimeter).apply(sideC);

        return multiply.apply(
                multiply.apply(deltaA).apply(deltaB)
        ).apply(deltaC);

    }

}

