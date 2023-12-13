package faang.school.godbless.school;

import java.util.function.Function;

public class Main {
    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double result = 0;
        if((a > 0 && b > 0 && c > 0) && (a + b > c && a + c > b && b + c > a)) {
            double half = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
            double halfMinusA = sub.apply(half).apply(a);
            double halfMinusB = sub.apply(half).apply(b);
            double halfMinusC = sub.apply(half).apply(c);
            double all = mul.apply(mul.apply(half).apply(halfMinusA)).apply(mul.apply(halfMinusB).apply(halfMinusC));
            result = sqrt.apply(all);
        }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.triangleArea(30,59,30));
    }
}
