package faang.school.godbless.backtoschool;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println(triangleArea(2, 2, 2));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a >= b + c || b >= a + c || c >= a + b || a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle does not exist");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        double pDiv2 = div.apply(
                sum.apply(a).apply(
                        sum.apply(b).apply(c)
                )
        ).apply(2D);
        double pDiv2SubA = sub.apply(pDiv2).apply(a);
        double pDiv2SubB = sub.apply(pDiv2).apply(b);
        double pDiv2SubC = sub.apply(pDiv2).apply(c);
        return sqrt.apply(
                mul.apply(pDiv2).apply(
                        mul.apply(
                                pDiv2SubA
                        ).apply(
                                mul.apply(
                                        pDiv2SubB
                                ).apply(
                                        pDiv2SubC
                                )
                        )
                )
        );
    }
}
