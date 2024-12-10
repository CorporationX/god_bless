package school.faang.sprint_2.task_45867;

import java.util.function.Function;

public class TriangleAreaCalculator {

    private Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    private Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    private Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    private Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    private Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Треугольник должен иметь положительные стороны");
        }
        if (add.apply(a).apply(b) <= c || add.apply(a).apply(c) <= b || add.apply(c).apply(b) <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }

        double halfPerimeter = divide.apply(add.apply(add.apply(a).apply(b)).apply(c)).apply(2.0);

        double subtractWithFirstSide = subtract.apply(halfPerimeter).apply(a);
        double subtractWithSecondSide = subtract.apply(halfPerimeter).apply(b);
        double subtractWithThirdSide = subtract.apply(halfPerimeter).apply(c);

        double multipleHalfPerimeterAndFirstSubtract = multiply.apply(halfPerimeter).apply(subtractWithFirstSide);
        double multipleFirstProductAndSecondSubtract =
                multiply.apply(multipleHalfPerimeterAndFirstSubtract).apply(subtractWithSecondSide);
        double underRoot = multiply.apply(multipleFirstProductAndSecondSubtract).apply(subtractWithThirdSide);

        return squareRoot.apply(underRoot);
    }
}

