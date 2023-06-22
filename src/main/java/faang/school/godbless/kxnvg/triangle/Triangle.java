package faang.school.godbless.kxnvg.triangle;

import java.util.function.Function;

public class Triangle {

    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Сторона треугольника не может быть отрицательным числом");
        }
        if (a >= sum.apply(b).apply(c) || b >= sum.apply(a).apply(c) || c >= sum.apply(a).apply(b)) {
            throw new IllegalArgumentException("Сторона треугольника не может быть больше суммы двух других сторон");
        }

        double halfPerimeter = div.apply(
                sum.apply(
                        sum.apply(b).apply(c)
                ).apply(a)
        ).apply(2.0);

        double difHalfPerimeterA = sub.apply(halfPerimeter).apply(a);
        double difHalfPerimeterB = sub.apply(halfPerimeter).apply(b);
        double difHalfPerimeterC = sub.apply(halfPerimeter).apply(c);

        double mulHalfPerimetersAndP = mul.apply(halfPerimeter).apply(
                mul.apply(difHalfPerimeterC).apply(
                        mul.apply(difHalfPerimeterA).apply(difHalfPerimeterB)));

        double square = sqrt.apply(mulHalfPerimetersAndP);
        return square;
    }
}
