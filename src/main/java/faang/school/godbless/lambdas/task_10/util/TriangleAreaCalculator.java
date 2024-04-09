package faang.school.godbless.lambdas.task_10.util;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class TriangleAreaCalculator {
    private final Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    private final Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
    private final Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
    private final Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
    private final Function<Double, Double> sqrt = Math::sqrt;

    public double getTriangleArea(double firstSide, double secondSide, double thirdSide) {
        if (!isTriangleExists(firstSide, secondSide, thirdSide)) {
            throw new IllegalArgumentException("Ошибка! Треугольника со сторонами "
                    + firstSide + " " + secondSide + " " + thirdSide + " не существует.");
        }
        double perimeter = sum.apply(sum.apply(firstSide).apply(secondSide)).apply(thirdSide);
        double halfPerimeter = div.apply(perimeter).apply(2.0);
        double multiplicationResult = mul.apply(
                mul.apply(
                        subtractSideFromHalfPerimeter(halfPerimeter, firstSide))
                        .apply(subtractSideFromHalfPerimeter(halfPerimeter, secondSide)))
                .apply(subtractSideFromHalfPerimeter(halfPerimeter, thirdSide));
        return sqrt.apply(mul.apply(halfPerimeter).apply(multiplicationResult));
    }

     private double subtractSideFromHalfPerimeter(double halfPerimeter, double side) {
        return sub.apply(halfPerimeter).apply(side);
    }

    private boolean isTriangleExists(double firstSide, double secondSide, double thirdSide) {
        return sub.apply(firstSide).apply(sum.apply(secondSide).apply(thirdSide)) > 0
                && sub.apply(secondSide).apply(sum.apply(firstSide).apply(thirdSide)) > 0
                && sub.apply(thirdSide).apply(sum.apply(secondSide).apply(firstSide)) > 0;
    }
}