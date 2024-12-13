package school.faang.task45916;

import java.util.function.Function;

public class TriangleAreaCalculator {

    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (isTriangle(a, b, c)) {
            double halfPerimeter = divide.apply(add.apply(add.apply(a).apply(b)).apply(c)).apply(2.0);
            double area = multiply.apply(halfPerimeter).apply(subtract.apply(halfPerimeter).apply(a));
            area = multiply.apply(area).apply(subtract.apply(halfPerimeter).apply(b));
            area = multiply.apply(area).apply(subtract.apply(halfPerimeter).apply(c));
            return squareRoot.apply(area);
        } else {
            throw new IllegalArgumentException("Такого треугольника не существует!");
        }
    }

    boolean isTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Длина стороны не может быть меньше или равна 0");
        }
        return (add.apply(a).apply(b) >= c)
                && (add.apply(a).apply(c) >= b)
                && (add.apply(b).apply(c) >= a);
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

