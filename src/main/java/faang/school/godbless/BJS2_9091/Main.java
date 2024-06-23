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

        Double halfPerimeter = div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0);
        Double hp_minus_a = sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(a);
        Double hp_minus_b = sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(b);
        Double hp_minus_c = sub.apply(div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0)).apply(c);
        Double hp_multiple_hp_minus_a = mul.apply(halfPerimeter).apply(hp_minus_a);
        Double hp_minus_b_multiple_hp_minus_c = mul.apply(hp_minus_b).apply(hp_minus_c);
        Double hp_mul_hp_minus_a_mul_hp_minus_b_mul_hp_minus_c = mul.apply(hp_multiple_hp_minus_a).apply(hp_minus_b_multiple_hp_minus_c);
        return sqrt.apply(hp_mul_hp_minus_a_mul_hp_minus_b_mul_hp_minus_c);
    }
}
