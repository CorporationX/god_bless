package faang.school.godbless.remember.school;

import java.util.function.Function;

public class GeometryUtils {

    private static Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    private static Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
    private static Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
    private static Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
    private static Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

    public static double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("A side should be more than zero");
        }

        if (sum.apply(a).apply(b) <= c || sum.apply(b).apply(c) <= a || sum.apply(a).apply(c) <= b) {
            throw new IllegalArgumentException("Wrong lengths. It's impossible to create triangle with such sides");
        }

        Double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2d);
        Double sub1 = sub.apply(p).apply(a);
        Double sub2 = sub.apply(p).apply(b);
        Double sub3 = sub.apply(p).apply(c);
        return sqrt.apply(mul.apply(p).apply(mul.apply(sub1).apply(mul.apply(sub2).apply(sub3))));
    }

}
