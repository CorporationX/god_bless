package school.faang.task_45919;

import java.util.function.Function;

public class TriangleAreaCalculator {

    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными числами");
        }

        if (add.apply(a).apply(c) <= b || add.apply(a).apply(b) <= c || add.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не может существовать");
        }

        double semiPerimeter = divide.apply(add.apply(c).apply(add.apply(b).apply(a))).apply(2.0);
        double semiPerimeterMinusSideA = subtract.apply(semiPerimeter).apply(a);
        double semiPerimeterMinusSideB = subtract.apply(semiPerimeter).apply(b);
        double semiPerimeterMinusSideC = subtract.apply(semiPerimeter).apply(c);

        double product1 = multiply.apply(semiPerimeter).apply(semiPerimeterMinusSideA);
        double product2 = multiply.apply(product1).apply(semiPerimeterMinusSideB);
        double heronProduct = multiply.apply(product2).apply(semiPerimeterMinusSideC);

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
