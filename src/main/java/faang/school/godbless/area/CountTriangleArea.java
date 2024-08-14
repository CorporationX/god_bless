package faang.school.godbless.area;

import java.util.function.Function;

public class CountTriangleArea {
    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (!(a + b < c) && !(b + c < a) && !(c + a < b)) {
            double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c))
                    .apply((double)2);

            double pa = sub.apply(p).apply(a);
            double pb = sub.apply(p).apply(b);
            double pc = sub.apply(p).apply(c);

            return sqrt.apply(mul.apply(mul.apply(p).apply(pa))
                    .apply(mul.apply(pb).apply(pc)));
        } else {
            System.out.println("Triangle does not exist");
            return null;
        }
    }
}
