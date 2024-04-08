package faang.school.godbless.bjs2_5041;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        // Даны три стороны треугольника, вычислить его площадь
        double result = triangleArea(10, 10, 10);
        System.out.println(result);
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        // Вычисляем площадь треугольника по формуле Герона.
        //(a + b + c) / 2.0;  // полупериметр
        double pp = div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0);
        //pp * (pp - a) * (pp - b) * (pp - c)
        double sub1 = sub.apply(pp).apply(a);
        double sub2 = sub.apply(pp).apply(b);
        double sub3 = sub.apply(pp).apply(c);
        double mul1 = mul.apply(pp).apply(sub1);
        double mul2 = mul.apply(mul1).apply(sub2);
        double mul3 = mul.apply(mul2).apply(sub3);

        return sqrt.apply(mul3);
    }
}
