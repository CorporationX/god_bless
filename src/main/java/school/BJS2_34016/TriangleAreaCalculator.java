package school.BJS2_34016;

import java.util.function.Function;

public class TriangleAreaCalculator {

    // Лямбда-функции для математических операций
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    // Метод для вычисления площади треугольника
    public Double calculateTriangleArea(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (add.apply(sideA).apply(sideB) > sideC &&
                add.apply(sideA).apply(sideC) > sideB &&
                add.apply(sideB).apply(sideC) > sideA) {
            double sumAandB = add.apply(sideA).apply(sideB);
            double sumAandBandC = add.apply(sumAandB).apply(sideC);
            double halfPerimeter = divide.apply(sumAandBandC).apply(2.0);
            double substHalfPerimeterAndA = subtract.apply(halfPerimeter).apply(sideA);
            double substHalfPerimeterAndB = subtract.apply(halfPerimeter).apply(sideB);
            double substHalfPerimeterAndC = subtract.apply(halfPerimeter).apply(sideC);
            double multiHalfPerimeterAndA = multiply.apply(halfPerimeter).apply(substHalfPerimeterAndA);
            double multiHalfPerimeterAndAAndB = multiply.apply(multiHalfPerimeterAndA).apply(substHalfPerimeterAndB);
            double multiHalfPerimeterAndAAndBAndC = multiply.apply(multiHalfPerimeterAndAAndB).apply(substHalfPerimeterAndC);
            return squareRoot.apply(multiHalfPerimeterAndAAndBAndC);
        } else {
            throw new IllegalArgumentException("Треугольник не соберется");
        }
    }

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();

        try {
            double area = calculator.calculateTriangleArea(2, 3, 9);
            System.out.println("Площадь треугольника: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}