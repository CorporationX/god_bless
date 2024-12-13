package school.faang.sprint_2.task_45893;

import java.util.function.Function;

public class TriangleAreaCalculator {

    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        double perimeter = add.apply(add.apply(a)
                        .apply(b))
                .apply(c);

        double halfPerimeter = divide.apply(perimeter)
                .apply(2.0);

        return squareRoot.apply(multiply.apply(multiply.apply(multiply.apply(halfPerimeter)
                                .apply(subtract.apply(halfPerimeter).apply(a)))
                        .apply(subtract.apply(halfPerimeter).apply(b)))
                .apply(subtract.apply(halfPerimeter).apply(c)));
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