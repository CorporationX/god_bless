package school.faangSprint2.t16;

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

        if (a <= 0 || b <= 0 || c <= 0 ||
                (a + b <= c) ||
                (a + c <= b) ||
                (b + c <= a)) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не может существовать");
        }

        Double halfPerimeter = divide.apply(
                add.apply(
                        add.apply(a).apply(b)).apply(c)).apply(2.0);

        double subA = subtract.apply(halfPerimeter).apply(a);
        double subB = subtract.apply(halfPerimeter).apply(b);
        double subC = subtract.apply(halfPerimeter).apply(c);


        return squareRoot.apply(multiply.apply(halfPerimeter)
                .apply(multiply.apply(subA)
                        .apply(multiply.apply(subB)
                                            .apply(subC))));
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