package derschrank.sprint02.task18.bjstwo_45912;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        Triangle triangle = new Triangle(a, b, c);
        checkSizeOfTriangle(triangle);
        double semiPerimeter = getSemiPerimeter(triangle);

        return getSquareRoot(
                getMuliMultiplyFromArray(new double[]{
                        semiPerimeter,
                        getSubtract(semiPerimeter, triangle.a()),
                        getSubtract(semiPerimeter, triangle.b()),
                        getSubtract(semiPerimeter, triangle.c()),
                })
        );
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

    private void checkSizeOfTriangle(Triangle t) {
        if (add.apply(t.a()).apply(t.b()) <= t.c()
                || add.apply(t.a()).apply(t.c()) <= t.b()
                || add.apply(t.b()).apply(t.c()) <= t.a()) {
            throw new IllegalArgumentException("Size of Triangle is wrong!");
        }
    }

    private double getSemiPerimeter(Triangle t) {
        return divide.apply(add.apply(
                        add.apply(
                                t.a()).apply(t.b())).apply(t.c()))
                .apply(2.0);
    }

    private double getSquareRoot(double fromWhat) {
        return squareRoot.apply(fromWhat);
    }

    private double getMultiply(double what, double times) {
        return multiply.apply(what).apply(times);
    }

    private double getMuliMultiplyFromArray(double[] numbersForMultiplay) {
        double result = 1;
        for (double number : numbersForMultiplay) {
            result = getMultiply(result, number);
        }
        return result;
    }

    private double getSubtract(double from, double what) {
        return subtract.apply(from).apply(what);
    }
}
