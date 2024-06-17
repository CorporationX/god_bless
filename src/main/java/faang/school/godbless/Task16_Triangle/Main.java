package faang.school.godbless.Task16_Triangle;

import java.util.function.Function;

public class Main {

    public static Double triangleArea(double a, double b, double c) {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a)
            throw new IllegalArgumentException("invalid sides");
        double semiPerimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.);
        double pa = sub.apply(semiPerimeter).apply(a);
        double pb = sub.apply(semiPerimeter).apply(b);
        double pc = sub.apply(semiPerimeter).apply(c);
        double prod = mul.apply(mul.apply(mul.apply(semiPerimeter).apply(pa)).apply(pb)).apply(pc);
        return sqrt.apply(prod);
    }

    public static void main(String[] args) {
        System.out.println(triangleArea(3., 4., 5.));
        System.out.println(triangleArea(6., 4., 5.));
        System.out.println(triangleArea(7., 4., 10.));
    }

}
