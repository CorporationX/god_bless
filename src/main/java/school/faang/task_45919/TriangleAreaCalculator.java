package school.faang.task_45919;

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
        //validation
        if (add.apply(a).apply(c) <= b || add.apply(a).apply(b) <= c || add.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не может существовать");
        }

        double semiPerimter = divide.apply(add.apply(c).apply(add.apply(b).apply(a))).apply(2.0);
        double semiPerimeterMinusSideA = subtract.apply(semiPerimter).apply(a);
        double semiPerimeterMinusSideB = subtract.apply(semiPerimter).apply(b);
        double semiPerimeterMinusSideC = subtract.apply(semiPerimter).apply(c);

        double heronProduct = multiply.apply(semiPerimter)
                .apply(multiply.apply(semiPerimeterMinusSideA)
                        .apply(multiply.apply(semiPerimeterMinusSideB)
                                .apply(semiPerimeterMinusSideC)));

        double result = squareRoot.apply(heronProduct);
        return result;
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
