package faang.school.godbless.remember_school;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {}

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        validateTriangle(a, b, c);

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        Double p = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);

        Double pSubtractA = sub.apply(p).apply(a);
        Double pSubtractB = sub.apply(p).apply(b);
        Double pSubtractC = sub.apply(p).apply(c);
        return sqrt.apply(
                mul.apply(
                        mul.apply(
                                mul.apply(p).apply(pSubtractA)
                        ).apply(pSubtractB)
                ).apply(pSubtractC)
        );
    }

    private static void validateTriangle(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new IllegalArgumentException("Each side must be greater than the sum of the other sides");
        }
    }
}