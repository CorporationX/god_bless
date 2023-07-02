package faang.school.godbless.school_triangle;

import java.util.function.Function;

public class TriangleAreaCalculator {

    void triangleValidator(double a, double b, double c) throws IllegalArgumentException {
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("Такого треугольника не существует!");
        }
    }

    public Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        triangleValidator(a, b, c);
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        Double twoSides = sum.apply(a).apply(b);
        Double perimeter = sum.apply(twoSides).apply(c);
        Double halfPerimeter = div.apply(perimeter).apply(2.0);
        Double halfPerimeterSubA = sub.apply(halfPerimeter).apply(a);
        Double halfPerimeterSubB = sub.apply(halfPerimeter).apply(b);
        Double halfPerimeterSubC = sub.apply(halfPerimeter).apply(c);
        Double mulAB = mul.apply(halfPerimeterSubA).apply(halfPerimeterSubB);
        Double multipleABC = mul.apply(mulAB).apply(halfPerimeterSubC);
        Double multiplePABC = mul.apply(halfPerimeter).apply(multipleABC);
        return sqrt.apply(multiplePABC);
    }
}

