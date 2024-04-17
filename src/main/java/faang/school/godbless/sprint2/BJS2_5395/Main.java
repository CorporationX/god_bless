package faang.school.godbless.sprint2.BJS2_5395;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(5.0, 6.0, 10.0));
        System.out.println(triangleArea(3.0, 7.0, 5.0));
    }

    private static double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0 || (a >= b + c) || (b >= a + c) || (c >= a + b)) {
            throw new IllegalArgumentException("Стороны треугольника переданы неверно!");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double halfPerimeter = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);

        double subA = sub.apply(halfPerimeter).apply(a);
        double subB = sub.apply(halfPerimeter).apply(b);
        double subC = sub.apply(halfPerimeter).apply(c);

        return sqrt.apply(mul.apply(
                mul.apply(
                        mul.apply(halfPerimeter).apply(subA)
                ).apply(subB)
        ).apply(subC));
    }
}
