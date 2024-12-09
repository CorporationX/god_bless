package school.faang.sprint_2.task_45867;

import java.util.function.Function;

public class TriangleAreaCalculator {

    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (add.apply(a).apply(b) <= c || add.apply(a).apply(c) <= b || add.apply(c).apply(b) <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
        double halfPerimeter = divide.apply(add.apply(add.apply(a).apply(b)).apply(c)).apply(2.0);
        double subtractWithFirstSide = subtract.apply(halfPerimeter).apply(a);
        double subtractWithSecondSide = subtract.apply(halfPerimeter).apply(b);
        double subtractWithThirdSide = subtract.apply(halfPerimeter).apply(c);
        double underRoot =
                multiply.apply(
                        multiply.apply(
                                multiply.apply(halfPerimeter).apply(subtractWithFirstSide)
                                )
                        .apply(subtractWithSecondSide)
                ).apply(subtractWithThirdSide);
        return squareRoot.apply(underRoot);
    }

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();

        try {
            double area = calculator.calculateTriangleArea(3, 4, 5);
            System.out.println("Площадь треугольника: " + area);
            calculator.calculateTriangleArea(1, 2, 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

