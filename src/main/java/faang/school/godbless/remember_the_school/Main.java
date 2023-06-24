package faang.school.godbless.remember_the_school;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        System.out.println(triangleArea(2., 2., 2.));
    }

    private static double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (!(a < b + c || b < a + c || c < b + a)) {
            throw new IllegalArgumentException("числа должны быть с плавающей точкой и больше 0 ");
        }
        Function<Double, Function<Double, Double>> sum = x -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = x -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = x -> y -> x - y;
        Function<Double, Function<Double, Double>> div = x -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double halfMeter = div.apply(sum.apply(a).apply(sum.apply(b).apply(c))).apply(2.);

        double subA = sub.apply(halfMeter).apply(a);

        double subB = sub.apply(halfMeter).apply(b);

        double subC = sub.apply(halfMeter).apply(c);

        double mults = mul.apply(mul.apply(halfMeter).apply(subA)).apply(mul.apply(subB).apply(subC));

        return sqrt.apply(mults);
    }
}
