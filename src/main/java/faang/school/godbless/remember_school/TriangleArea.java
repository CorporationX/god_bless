package faang.school.godbless.remember_school;

import java.util.function.Function;

public class TriangleArea {

    // S = sqrt(p(p-a)*(p-b)*(p-c)), p = (a+b+c)/2;
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double pDiv2 = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);

        double pSubA = sub.apply(pDiv2).apply(a);
        double pSubB = sub.apply(pDiv2).apply(b);
        double pSubC = sub.apply(pDiv2).apply(c);

        double multiplies = mul.apply(pDiv2).apply(
                mul.apply(pSubA).apply(
                        mul.apply(pSubB).apply(pSubC)
                )
        );

        return sqrt.apply(multiplies);
    }
}
