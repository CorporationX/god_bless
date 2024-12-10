package school.faang.task45870;

import java.util.function.Function;

public class TriangleAreaCalculator {
    private static final double CONST_FOR_SEMI_PERIMETER = 2;

    private final Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    private final Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    private final Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    private final Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    private final Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("A triangle cannot have negative sides");
        }
        if (add.apply(a).apply(b) <= c) {
            throw new IllegalArgumentException("The sum of sides a and b cannot be less than or equal to side c");
        }

        if (add.apply(a).apply(c) <= b) {
            throw new IllegalArgumentException("The sum of sides a and c cannot be less than or equal to side b");
        }

        if (add.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("The sum of sides b and c cannot be less than or equal to side a");
        }

        double semiPerimeter = semiPerimeter(a, b, c);

        double first = subtractHalfMeterAndSide(semiPerimeter, a);
        double second = subtractHalfMeterAndSide(semiPerimeter, b);
        double third = subtractHalfMeterAndSide(semiPerimeter, c);

        return triangleArea(multiplySides(semiPerimeter, first, second, third));
    }

    private double semiPerimeter(double a, double b, double c) {
        return divide.apply(add.apply(add.apply(a).apply(b)).apply(c)).apply(CONST_FOR_SEMI_PERIMETER);
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
