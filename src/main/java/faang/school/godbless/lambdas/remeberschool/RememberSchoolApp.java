package faang.school.godbless.lambdas.remeberschool;

import java.util.function.Function;

public class RememberSchoolApp {

    public static void main(String[] args) {
        double a = 7.5;
        double b = 9.2;
        double c = 5.1;

        Double s = triangleArea(a, b, c);
        System.out.println("s = " + s);
    }

    private static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        Double p = div.apply(sum                                    // p = (a + b + c) / 2
                        .apply(sum.apply(a).apply(b)).apply(c))
                        .apply(2.0);
        Double area = sqrt.apply(mul                                // S = sqrt(p * (p−a) * (p−b) * (p−c))
                .apply(p)
                .apply(mul
                        .apply(sub.apply(p).apply(a))
                        .apply(mul
                                .apply(sub.apply(p).apply(b))
                                .apply(sub.apply(p).apply(c)))));
        return area;
    }

}
