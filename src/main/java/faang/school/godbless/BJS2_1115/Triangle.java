package faang.school.godbless.BJS2_1115;

import java.util.function.Function;

public class Triangle {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Wrong input");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double semiperimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        double perimMinA = sub.apply(semiperimeter).apply(a);
        double perimMinB = sub.apply(semiperimeter).apply(b);
        double perimMinC = sub.apply(semiperimeter).apply(c);

        double underSquare = mul.apply(mul.apply(mul.apply(perimMinA).apply(perimMinB)).apply(perimMinC))
                .apply(semiperimeter);

        return sqrt.apply(underSquare);
    }
}