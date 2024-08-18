package faang.school.godbless.area;

import java.util.function.Function;

public class CountTriangleArea {
    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (!(a + b < c) && !(b + c < a) && !(c + a < b)) {
            Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
            Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
            Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
            Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
            Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

            double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c))
                    .apply(2.0);

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
