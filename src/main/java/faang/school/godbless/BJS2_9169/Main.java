package faang.school.godbless.BJS2_9169;

import java.util.function.Function;

public class Main {
    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double p = sum.apply(a).apply(b);
        p = sum.apply(p).apply(c);
        p = div.apply(p).apply(2d);

        double pa = sub.apply(p).apply(a);
        double pb = sub.apply(p).apply(b);
        double pc = sub.apply(p).apply(c);
        double pabc = mul.apply(mul.apply(pa).apply(pb)).apply(pc);

        double s = sqrt.apply(mul.apply(p).apply(pabc));
        return s;
    }

    public static void main(String[] args) {
        System.out.println(triangleArea(10, 8, 6));
    }
}
