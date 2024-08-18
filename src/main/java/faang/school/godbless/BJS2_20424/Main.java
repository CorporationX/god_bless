package faang.school.godbless.BJS2_20424;

import java.util.function.Function;

public class Main {
    public double triangleArea(double a, double b, double c) {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        double halfPerimeter = div.apply(sum.compose(sum.apply(a)).apply(b).apply(c)).apply(2.0);
        double aSub = sub.apply(halfPerimeter).apply(a);
        double bSub = sub.apply(halfPerimeter).apply(b);
        double cSub = sub.apply(halfPerimeter).apply(c);
        double forRootNumber = mul.apply(halfPerimeter).apply(mul.apply(aSub).apply(mul.apply(bSub).apply(cSub)));

        return sqrt.apply(forRootNumber);
    }

    public static void main(String[] args) {
        System.out.println(new Main().triangleArea(4, 8, 5));;
    }
}
