package Sprint_3_Task9;

import java.util.function.Function;

public class School {

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double pDiv2 = div.apply(sum.apply(
                sum.apply(a).apply(b)).apply(c)
        ).apply(2.0);

        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);

        return sqrt.apply(mul.apply(mul.apply
                (mul.apply(pDiv2
                ).apply(pDiv2MinusA)).apply(pDiv2MinusB)).apply(pDiv2MinusC));
    }

    public static void main(String[] args) {
        double a = 3;
        double b = 4;
        double c = 5;
        System.out.println(triangleArea(a,b,c));
    }
}
