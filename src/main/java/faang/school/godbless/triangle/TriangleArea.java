package faang.school.godbless.triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TriangleArea {
    public static double getTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        validate(a, b, c);

        // given functions
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double[] sides = {a, b, c};
        List<Double> subHalfPFromSides = new ArrayList<>();
        double half = 2.0;
        double halfP;
        double result;

        // got perimeter
        result = a;
        for (int i = 0; i < sides.length - 1; i++) {
            result = sum.apply(result).apply(sides[i + 1]);
        }

        // got perimeter half
        result = div.apply(result).apply(half);
        halfP = result;

        // got [perimeter half - side] for all sides
        for (double side : sides) {
            side = sub.apply(halfP).apply(side);
            subHalfPFromSides.add(side);
        }

        // got square
        result = halfP;
        for (Double subHalfPFromSide : subHalfPFromSides) {
            result = mul.apply(result).apply(subHalfPFromSide);
        }
        result = sqrt.apply(result);

        System.out.println(result);
        return result;
    }

    private  static void validate (double a, double b, double c) throws IllegalArgumentException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Invalid arguments");
        }
    }
}
