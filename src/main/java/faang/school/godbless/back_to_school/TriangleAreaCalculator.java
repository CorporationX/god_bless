package faang.school.godbless.back_to_school;

import java.text.DecimalFormat;
import java.util.function.Function;

public class TriangleAreaCalculator {

    public Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        validateTriangleSides(a, b, c);

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double pDiv2 = div.apply((sum.apply(sum.apply(a).apply(b)).apply(c))).apply(2.0);
        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);
        double area = sqrt.apply(
                mul.apply(pDiv2).apply(mul.apply(pDiv2MinusA).apply(
                        mul.apply(pDiv2MinusB).apply(pDiv2MinusC))));

        return formatToThirdDecimal(area);
    }

    private double formatToThirdDecimal(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String formattedValue = decimalFormat.format(value);

        return Double.parseDouble(formattedValue);
    }

    private void validateTriangleSides(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Invalid triangle sides length. Sides length must be positive.");
        }

        if (a >= b + c || b >= c + a || c >= a + b) {
            throw new IllegalArgumentException("Invalid triangle side length. Side length can't be bigger or equal to sum of the others");
        }
    }
}
