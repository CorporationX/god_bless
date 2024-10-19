package school.faang.backtoschool;

import java.util.function.Function;

public class TriangleAreaCalculator {

    // Лямбда-функции для математических операций
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    // Метод для вычисления площади треугольника
    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {

        // Напишите ваш код здесь
        if (add.apply(a).apply(b) < c || add.apply(c).apply(a) < b || add.apply(c).apply(b) < a) {
            throw new IllegalArgumentException("Такого треугольника не существует!");
        }
        double semiPerimeter = divide.apply(add.apply(add.apply(a).apply(b)).apply(c)).apply(2.0);
        double semiPerimeterMinusSideA = subtract.apply(semiPerimeter).apply(a);
        double semiPerimeterMinusSideB = subtract.apply(semiPerimeter).apply(b);
        double semiPerimeterMinusSideC = subtract.apply(semiPerimeter).apply(c);
        double heronProduct = multiply
                        .apply(semiPerimeter)
                        .apply(multiply.apply(semiPerimeterMinusSideA)
                        .apply(multiply.apply(semiPerimeterMinusSideB).apply(semiPerimeterMinusSideC)));
        return squareRoot.apply(heronProduct);
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