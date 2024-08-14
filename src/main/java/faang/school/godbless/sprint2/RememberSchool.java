package faang.school.godbless.sprint2;

import java.util.function.Function;

public class RememberSchool {
    Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;

    private boolean isInvalid(double firstInSum, double secondInSum, double third) {
        double sumTwoSides = sum.apply(firstInSum).apply(secondInSum);
        return third >= sumTwoSides;
    }

    private Double subBetween(double halfPerimeter, double side) {
        return sub.apply(halfPerimeter).apply(side);
    }

    public Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (isInvalid(a, b, c) || isInvalid(b, c, a) || isInvalid(a, c, b)) {
            throw new IllegalArgumentException("Треугольника с такими сторонами не существует");
        }

        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double perimeter = sum.apply(sum.apply(a).apply(b)).apply(c);
        double halfPerimeter = div.apply(perimeter).apply(2.0);
        double squareOfSquare = mul.apply(halfPerimeter)
                .apply(mul.apply(subBetween(halfPerimeter, a))
                        .apply(mul.apply(subBetween(halfPerimeter, b))
                                .apply(subBetween(halfPerimeter, c))));
        return sqrt.apply(squareOfSquare);
    }
}
