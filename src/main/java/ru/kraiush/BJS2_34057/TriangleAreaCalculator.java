package ru.kraiush.BJS2_34057;

import java.util.function.Function;

public class TriangleAreaCalculator {

    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (add.apply(a).apply(b) <= c || add.apply(b).apply(c) <= a || add.apply(c).apply(a) <= b) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        double semiPerimeter = divide.apply(
                add.apply(a).apply(
                        add.apply(b).apply(c)
                )
        ).apply(2.0);
        return squareRoot.apply(
                multiply.apply(
                                multiply.apply(semiPerimeter).apply(subtract.apply(semiPerimeter).apply(a)))
                        .apply(
                                multiply.apply(subtract.apply(semiPerimeter).apply(b)).apply(subtract.apply(semiPerimeter).apply(c))
                        )

        );
    }

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();

        try {
            double area = calculator.calculateTriangleArea(3, 4, 5);
            System.out.println("Triangle Area: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
