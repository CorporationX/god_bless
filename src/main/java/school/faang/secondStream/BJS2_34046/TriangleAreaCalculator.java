package school.faang.secondStream.BJS2_34046;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = Math::sqrt;

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException();
        }
        double perimeter = add.apply(add.apply(a).apply(b)).apply(c);
        double semiperimeter = divide.apply(perimeter).apply(2.0);

        double semiPerimeterMinusSideA = subtract.apply(semiperimeter).apply(a);
        double semiPerimeterMinusSideB = subtract.apply(semiperimeter).apply(b);
        double semiPerimeterMinusSideC = subtract.apply(semiperimeter).apply(c);

        double underTheRoot = multiply
                .apply(semiperimeter)
                .apply(multiply
                        .apply(semiPerimeterMinusSideA)
                        .apply(multiply.
                                apply(semiPerimeterMinusSideB)
                                .apply(semiPerimeterMinusSideC)
                        )
                );

        return squareRoot.apply(underTheRoot);
    }

    private boolean isValidTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не может существовать");
        }
        if (add.apply(a).apply(b) <= c ||
                add.apply(a).apply(c) <= b ||
                add.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не может существовать");
        }
        return true;
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
