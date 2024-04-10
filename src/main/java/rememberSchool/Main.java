package rememberSchool;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(2,3,4));
    }

    private static Double triangleArea(double a, double b, double c) {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double halfMeter = div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2d);
        double differenceWithA = sub.apply(halfMeter).apply(a);
        double differenceWithB = sub.apply(halfMeter).apply(b);
        double differenceWithC = sub.apply(halfMeter).apply(c);
        double area = sqrt.apply(mul.apply(differenceWithC).apply(mul.apply(differenceWithB).apply(mul.apply(halfMeter).apply(differenceWithA))));

        return area;
    }
}
