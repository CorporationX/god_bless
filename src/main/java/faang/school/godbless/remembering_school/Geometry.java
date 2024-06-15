package faang.school.godbless.remembering_school;

import java.util.function.Function;

public class Geometry {
    // Даны три стороны треугольника, вычислить его площадь
    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if(sum.apply(a).apply(b) <= c || sum.apply(a).apply(c) <= b || sum.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Impossible triangle");
        }
//        Herons simplified equation
        double aSQ = mul.apply(a).apply(a);
        double bSQ = mul.apply(b).apply(b);
        double cSQ = mul.apply(c).apply(c);

        double sumAndDif = sub.apply(sum.apply(aSQ).apply(bSQ)).apply(cSQ);
        double squared = mul.apply(sumAndDif).apply(sumAndDif);
        double beforeRoot = sub.apply(mul.apply(4d).apply(mul.apply(aSQ).apply(bSQ))).apply(squared);
        double area = div.apply(sqrt.apply(beforeRoot)).apply(4d);
//        rounding to nearest 3rd decimal
        return Math.round(area*1000)/1000D;
    }
}
