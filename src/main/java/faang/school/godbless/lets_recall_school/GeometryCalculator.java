package faang.school.godbless.lets_recall_school;

import java.util.function.Function;

public class GeometryCalculator {

    public Double triangleArea(double sideA, double sideB, double sideC) {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        validateSides(sideA, sideB, sideC);

        double sumAB = sum.apply(sideA).apply(sideB);
        double sumABC = sum.apply(sumAB).apply(sideC);

        double semiPerimeter = div.apply(sumABC).apply(2.0);

        double subPA = sub.apply(semiPerimeter).apply(sideA);
        double subPB = sub.apply(semiPerimeter).apply(sideB);
        double subPC = sub.apply(semiPerimeter).apply(sideC);

        double mulABC = mul.apply(subPA).apply(mul.apply(subPB).apply(subPC));

        double areaSquare = mul.apply(semiPerimeter).apply(mulABC);

        return sqrt.apply(areaSquare);
    }

    void validateSides(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Side lengths must be positive numbers.");
        }

        if ((sideA + sideB) < sideC || (sideA + sideC) < sideB || (sideB + sideC) < sideA) {
            throw new IllegalArgumentException("Side lengths are violating Triangle Inequality Theorem.");
        }
    }
}
