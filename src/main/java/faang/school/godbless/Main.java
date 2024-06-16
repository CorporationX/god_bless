package faang.school.godbless;

import java.util.function.Function;

public class Main {
    static Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    static Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
    static Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
    static Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
    static Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

    public static void main(String[] args) {
        double a = 2;
        double b = 2;
        double c = 3;

        System.out.println(triangleInequality(a, b, c));

        System.out.println(triangleArea(a, b, c));
    }

    // Даны три стороны треугольника, вычислить его площадь
    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        double result;

        double pDiv2 = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);

        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);
        double mulABC = mul.apply
                (mul.apply(pDiv2MinusA).apply(pDiv2MinusB))
                .apply(pDiv2MinusC);

        result = sqrt.apply(
                mul.apply(pDiv2).apply(mulABC));

        sqrt.apply(result);

        return result;
    }


    public static boolean triangleInequality(double a, double b, double c) {
        return checkFirst(a, b, c) ||
                checkSecond(a, b, c) ||
                checkThird(a, b, c);
    }

    private static boolean checkFirst(double a, double b, double c) {
        return mul.apply(a).apply(b) < (mul.apply(a).apply(c)) + ((mul.apply(c).apply(b)));
    }

    private static boolean checkSecond(double a, double b, double c) {
        return mul.apply(a).apply(c) < (mul.apply(a).apply(b)) + ((mul.apply(b).apply(c)));
    }

    private static boolean checkThird(double a, double b, double c) {
        return mul.apply(b).apply(c) < (mul.apply(b).apply(a)) + ((mul.apply(a).apply(c)));
    }

}
