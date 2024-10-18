package rememberSchool;

import java.util.function.Function;

public class TriangleAreaCalculator {

    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = Math::sqrt;

    public Double calculateTriangleArea(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (add.apply(sideA).apply(sideB) <= sideC || add.apply(sideB).apply(sideC) <= sideA || add.apply(sideA).apply(sideC) <= sideB) {
            throw new IllegalArgumentException("Треугольник не существовует");
        } else {
            double semiPerimeter = divide.apply(add.apply(add.apply(sideA).apply(sideB)).apply(sideC)).apply(2.0);
            double semiperimetrMinusSideA = subtract.apply(semiPerimeter).apply(sideA);
            double semiperimetrMinusSideB = subtract.apply(semiPerimeter).apply(sideB);
            double semiperimetrMinusSideC = subtract.apply(semiPerimeter).apply(sideC);
            return squareRoot.apply(
                    multiply.apply(semiPerimeter).apply(
                            multiply.apply(semiperimetrMinusSideA).apply(
                                    multiply.apply(semiperimetrMinusSideB).apply(semiperimetrMinusSideC)
                            )
                    )
            );
        }
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
