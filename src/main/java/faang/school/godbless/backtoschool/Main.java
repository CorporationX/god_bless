package faang.school.godbless.backtoschool;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println(triangleArea(2, 2,2));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a > b + c || b > a + c || c > a + b) {
            throw new IllegalArgumentException("Triangle does not exist");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        double halfP = div.apply(
                sum.apply(a).apply(
                        sum.apply(b).apply(c)
                )
        ).apply(2D);
        return sqrt.apply(
                mul.apply(halfP).apply(
                        mul.apply(
                                sub.apply(halfP).apply(a)
                        ).apply(
                                mul.apply(
                                        sub.apply(halfP).apply(b)
                                ).apply(
                                        sub.apply(halfP).apply(c)
                                )
                        )
                )
        );
    }
}
