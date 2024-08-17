package faang.school.godbless.BJS2_20597;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double a = 10;
        double b = 5;
        double c = 8;
        System.out.println("Triangle (" + a + ", " + b + ", " + c + ") area is " + triangleArea(a, b, c));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0 || !isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;
        double p = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2d);
        double paSub = sub.apply(p).apply(a);
        double pbSub = sub.apply(p).apply(b);
        double pcSub = sub.apply(p).apply(c);
        double p_paMul = mul.apply(p).apply(paSub);
        double pb_pcMul = mul.apply(pbSub).apply(pcSub);
        double resultMul = mul.apply(p_paMul).apply(pb_pcMul);
        return sqrt.apply(resultMul);
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
