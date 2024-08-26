package faang.school.godbless.fi.school;

import java.util.function.Function;

public class Main {

    public static double triangleArea(double a, double b, double c) {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;

        Function<Double, Double> sqrt = Math::sqrt;

        double halfPerimeter = div.apply(sum.compose(sum.apply(a)).apply(b).apply(c)).apply(2.0);

        double aSub = sub.apply(halfPerimeter).apply(a);
        double bSub = sub.apply(halfPerimeter).apply(b);
        double cSub = sub.apply(halfPerimeter).apply(c);

        return sqrt.apply(mul.apply(halfPerimeter).apply(mul.apply(aSub).apply(mul.apply(bSub).apply(cSub))));
    }

    public static void main(String[] args) {
        System.out.println(triangleArea(3, 6, 4));
    }

}