package school.faang.task_45841;

import java.util.function.Function;

public class TriangleAreaCalculator {

    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (!isTriangle(a, b, c)) {
            throw new IllegalArgumentException("The wrong sides of the triangle");
        }

        double halfMeter = divide.apply(add.apply(add.apply(a).apply(b)).apply(c)).apply(2D);

        double firstDivideHalfMeterNumerator = subtract.apply(halfMeter).apply(a);
        double secondDivideHalfMeterNumerator = subtract.apply(halfMeter).apply(b);
        double thirdDivideHalfMeterNumerator = subtract.apply(halfMeter).apply(c);

        double heightNumerator = multiply.apply(
                        multiply.apply(multiply.apply(halfMeter)
                                        .apply(firstDivideHalfMeterNumerator))
                                .apply(secondDivideHalfMeterNumerator))
                .apply(thirdDivideHalfMeterNumerator);

        double sqrt = squareRoot.apply(heightNumerator);
        double height = divide.apply(multiply.apply(2D).apply(sqrt)).apply(a);

        double areaTriangle = multiply.apply(multiply.apply(0.5).apply(a)).apply(height);

        return areaTriangle;
    }

    private boolean isTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }

        boolean firstCondition = add.apply(a).apply(b) > c;
        boolean secondCondition = add.apply(a).apply(c) > b;
        boolean thirdCondition = add.apply(b).apply(c) > a;

        return firstCondition && secondCondition && thirdCondition;
    }
}
