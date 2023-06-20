package remember_school;

import java.util.function.Function;

public class Triangle {
    // Given three sides of a triangle, calculate its area
    public Double triangleArea(double a, double b, double c) {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }

        double pDiv2 = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);

        // Calculate (p-a), (p-b), (p-c)
        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);

        // Calculate the area using Geron's formula
        double area = sqrt.apply(
                mul.apply(
                        mul.apply(
                                mul.apply(pDiv2).apply(pDiv2MinusA)
                        ).apply(pDiv2MinusB)
                ).apply(pDiv2MinusC)
        );

        return area;
    }
}
