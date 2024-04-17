package faang.school.godbless.remember_school;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double a = 3.0;
        double b = 4.0;
        double c = 5.0;
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;
        boolean condition = a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a;
        if (condition) {
            throw new IllegalArgumentException("Неправильное значение");
        }
        double pDiv2 = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);
        double area = sqrt.apply(mul.apply(mul.apply(mul.apply(pDiv2).apply(pDiv2MinusA)).
                apply(pDiv2MinusB)).apply(pDiv2MinusC));
        System.out.println("Площадь треугольника: " + area);
    }
}
