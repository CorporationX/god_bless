package faang.school.godbless;

import java.util.function.Function;

public class Triangle {
    public double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = x -> y -> x + y;
        Function<Double, Function<Double, Double>> sub = x -> y -> x - y;
        Function<Double, Function<Double, Double>> mul = x -> y -> x * y;
        Function<Double, Function<Double, Double>> div = x -> y -> x / y;
        Function<Double, Double> sqrt = x -> Math.sqrt(x);

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive numbers");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Triangle with the given sides does not exist");
        }

        double ab = sum.apply(a).apply(b); // a+b
        double p = div.apply(sum.apply(ab).apply(c)).apply(2.0); // (a+b+c) /2
        double pa = sub.apply(p).apply(a); // p - a
        double pb = sub.apply(p).apply(b); // p - b
        double pc = sub.apply(p).apply(c); // p - c
        double areaSquared1 = mul.apply(p).apply(pa); // p * pa
        double aresSquared2 = mul.apply(pb).apply(pc); // pb * pc
        double areaSquared = mul.apply(areaSquared1).apply(aresSquared2); // ppc * pbpc
        double area = sqrt.apply(areaSquared);

        return area;
    }
}
