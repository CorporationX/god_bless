package faang.school.godbless;

import java.util.Objects;
import java.util.function.Function;

public class Application {
    public static void main(String... args) {
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        //S=sqrt(p⋅(p−a)⋅(p−b)⋅(p−c))
        validate(a,b,c);

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        double pA = sub.apply(p).apply(a);
        double pB = sub.apply(p).apply(b);
        double pC = sub.apply(p).apply(c);
        double mullAll = mul.apply(mul.apply(mul.apply(p).apply(pA)).apply(pB)).apply(pC);
        return sqrt.apply(mullAll);
    }

    private static void validate(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Values should be more then 0");
        }
    }
}
