package school.faang.task45870;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("A triangle cannot have negative sides");
        }
        if (add.apply(a).apply(b) <= c && add.apply(a).apply(c) <= b && add.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("The sum of the two sides cannot be less than the third");
        }

        double halfMeter = halfMeter(a, b, c);

        double first = subtractHalfMeterAndSide(halfMeter, a);
        double second = subtractHalfMeterAndSide(halfMeter, b);
        double third = subtractHalfMeterAndSide(halfMeter, c);

        return triangleArea(multiplySides(halfMeter, first, second, third));
    }

    private double halfMeter(double a, double b, double c) {
        return divide.apply(add.apply(add.apply(a).apply(b)).apply(c)).apply(2.0);
    }

    private double subtractHalfMeterAndSide(double halfMeter, double side) {
        return subtract.apply(halfMeter).apply(side);
    }

    private double multiplySides(double halfMeter, double a, double b, double c) {
        return multiply.apply(multiply.apply(multiply.apply(a).apply(b)).apply(c)).apply(halfMeter);
    }

    private double triangleArea(double multiplyAllSides) {
        return squareRoot.apply(multiplyAllSides);
    }

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();

        try {
            double area = calculator.calculateTriangleArea(3, 3, 3);
            System.out.println("Площадь треугольника: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
