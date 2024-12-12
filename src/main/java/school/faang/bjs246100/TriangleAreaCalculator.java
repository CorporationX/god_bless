package school.faang.bjs246100;

import java.util.function.Function;

public class TriangleAreaCalculator {

    // Лямбда-функции для математических операций
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = Math::sqrt;

    // Метод для вычисления площади треугольника
    public Double calculateTriangleArea(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (add.apply(sideA).apply(sideB) < sideC
                || add.apply(sideB).apply(sideC) < sideA
                || add.apply(sideA).apply(sideC) < sideB) {
            throw new IllegalArgumentException("Такого треугольника не существует");
        }
        // Напишите ваш код здесь
        Double semiPerimeter = getSemiPerimeter(sideA, sideB, sideC);

        Double subtractA = subtract.apply(semiPerimeter).apply(sideA);
        Double subtractB = subtract.apply(semiPerimeter).apply(sideB);
        Double subtractC = subtract.apply(semiPerimeter).apply(sideC);

        return squareRoot.apply(multiply.apply(multiply.apply(multiply.apply(semiPerimeter)
                .apply(subtractA)).apply(subtractB)).apply(subtractC));
    }

    private Double getSemiPerimeter(Double a, Double b, Double c) {
        return divide.apply(add.apply(add.apply(a).apply(b)).apply(c)).apply(2.0);
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