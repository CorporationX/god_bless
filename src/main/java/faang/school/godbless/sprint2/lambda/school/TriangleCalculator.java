package faang.school.godbless.sprint2.lambda.school;

import java.util.function.Function;

public class TriangleCalculator {

    Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
    Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
    Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
    Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

    public Double getTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        validateTriangle(a, b, c);
        Double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        Double pSubA = sub.apply(p).apply(a);
        Double pSubB = sub.apply(p).apply(b);
        Double pSubC = sub.apply(p).apply(c);

        Double pMulPSubA = mul.apply(p).apply(pSubA);
        Double pMulPSubAMulPSubB = mul.apply(pMulPSubA).apply(pSubB);
        Double finalProductForHeronFormula = mul.apply(pMulPSubAMulPSubB).apply(pSubC);

        Double area = sqrt.apply(finalProductForHeronFormula);
        return area;
    }

    private void validateTriangle(double a, double b, double c) {
        boolean areAllSidesPositive = a > 0 && b > 0 && c > 0;
        boolean isValidTriangle = a + b > c && a + c > b && b + c > a;

        if (!areAllSidesPositive || !isValidTriangle) {
            throw new IllegalArgumentException("Invalid triangle dimensions.");
        }
    }
}
