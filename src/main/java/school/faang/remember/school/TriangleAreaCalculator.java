package school.faang.remember.school;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> sum = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> mul = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> sub = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> div = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = Math::sqrt;

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0 ||
                sum.apply(a).apply(b) <= c ||
                sum.apply(a).apply(c) <= b ||
                sum.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не может существовать.");
        }

        double semiP = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.00);

        double semiPSubA = sub.apply(semiP).apply(a);
        double semiPSubB = sub.apply(semiP).apply(b);
        double semiPSubC = sub.apply(semiP).apply(c);

        double semiPMulSemiPDivA = mul.apply(semiP).apply(semiPSubA);
        double semiPDivBMulSemiPDivC = mul.apply(semiPSubB).apply(semiPSubC);

        return squareRoot.apply(mul.apply(semiPMulSemiPDivA).apply(semiPDivBMulSemiPDivC));
    }
}
