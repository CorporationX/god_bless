package faang.school.godbless.bjs2_20408;

import java.util.function.Function;

public class Main {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (sum.apply(a).apply(b) <= c || sum.apply(a).apply(c) <= b || sum.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException();
        }

        var sumAB = sum.apply(a).apply(b);
        var sumABC = sum.apply(sumAB).apply(c);
        var p = div.apply(sumABC).apply(2.0);

        var subP = sub.apply(p);
        var subPA = subP.apply(a);
        var subPB = subP.apply(b);
        var subPC = subP.apply(c);

        var mulPA = mul.apply(p).apply(subPA);
        var mulBC = mul.apply(subPB).apply(subPC);
        var mulAll = mul.apply(mulPA).apply(mulBC);

        return sqrt.apply(mulAll);
    }
}
