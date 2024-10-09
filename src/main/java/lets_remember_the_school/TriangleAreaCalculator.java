package lets_remember_the_school;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = Math::sqrt;

    /**
     * Calculate the area of the triangle with given sides.
     *
     * @param a the length of the first side
     * @param b the length of the second side
     * @param c the length of the third side
     * @return the area of the triangle
     * @throws IllegalArgumentException if the given sides don't form a valid triangle
     */
    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (add.apply(a).apply(b) <= c || add.apply(a).apply(c) <= b || add.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не может существовать");
        }

        Double halfMeter = divide.apply(add.apply(add.apply(a).apply(b)).apply(c)).apply(2.0);

        Double diffHalfMeterAndA = subtract.apply(halfMeter).apply(a);
        Double diffHalfMeterAndB = subtract.apply(halfMeter).apply(b);
        Double diffHalfMeterAndC = subtract.apply(halfMeter).apply(c);

        Double resultMultiply = multiply.apply(halfMeter)
                .apply(multiply.apply(multiply
                                .apply(diffHalfMeterAndA)
                                .apply(diffHalfMeterAndB))
                        .apply(diffHalfMeterAndC));

        return squareRoot.apply(resultMultiply);
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
