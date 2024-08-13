package faang.school.godbless.BJS2_20435;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(8, 4, 5));
        System.out.println(triangleArea(5, 5, 5));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double halfPerimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        double subPA = sub.apply(halfPerimeter).apply(a);
        double subPB = sub.apply(halfPerimeter).apply(b);
        double subPC = sub.apply(halfPerimeter).apply(c);

        return sqrt.apply(mul.apply(mul.apply(mul.apply(subPA).apply(subPB)).apply(subPC)).apply(halfPerimeter));
    }
}
