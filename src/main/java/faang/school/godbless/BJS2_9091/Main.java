package faang.school.godbless.BJS2_9091;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Площадь треугольника = " + triangleArea(3, 4, 5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Даны три стороны треугольника, вычислить его площадь
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Сторона треугольника не может быть отрицательным значением");
        }
        if (a == 0 || b == 0 || c == 0) {
            throw new IllegalArgumentException("Сторона треугольника не может быть равна нулю");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        Double result;
//        Double perimeter = sum.apply(c).apply(sum.apply(a).apply(b));
//        Double halfPerimeter = div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0);
//        Double hpa = sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(a);
//        Double hpb = sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(b);
//        Double hpc = sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(c);
//        Double hppa = mul.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(a));
//        Double pbpc = mul.apply(sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(b)).apply(sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(c));
//        Double hppapbpc = mul.apply(mul.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(a))).apply(mul.apply(sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(b)).apply(sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(c)));
        result = sqrt.apply(mul.apply(mul.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(a))).apply(mul.apply(sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(b)).apply(sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(c))));

        return result;
    }
}
