package faang.school.godbless.rememberschool2689;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(2.0, 5.5, 7.3));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        // S = √(p * (p — a) * (p — b) * (p — c))
        Double halfPerimetr = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        Double subPA = sub.apply(halfPerimetr).apply(a);
        Double subPB = sub.apply(halfPerimetr).apply(b);
        Double subPC = sub.apply(halfPerimetr).apply(c);
        return sqrt.apply(mul.apply(mul.apply(mul.apply(halfPerimetr).apply(subPA)).apply(subPB)).apply(subPC));

    }
}
