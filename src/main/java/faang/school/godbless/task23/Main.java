package faang.school.godbless.task23;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double p = (double) (4 + 3 + 6) / 2;
        double test = Math.sqrt(p * (p - 4) * (p - 3) * (p - 6));

        System.out.println(test);
        System.out.println(triangleArea(4, 3, 6));
    }

    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        // Шаг 1: Проверка на допустимость сторон треугольника
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными числами.");
        }
        if (sum.apply(a).apply(b) <= c || sum.apply(a).apply(c) <= b || sum.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Не выполняется неравенство треугольника.");
        }

        // Шаг 2: Вычисление полупериметра
        double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        // Шаг 3: Вычисление (p - a)
        double p_minus_a = sub.apply(p).apply(a);

        // Шаг 4: Вычисление (p - b)
        double p_minus_b = sub.apply(p).apply(b);

        // Шаг 5: Вычисление (p - c)
        double p_minus_c = sub.apply(p).apply(c);

        // Шаг 6: Вычисление p * (p - a)
        double p_times_p_minus_a = mul.apply(p).apply(p_minus_a);

        // Шаг 7: Вычисление p * (p - a) * (p - b)
        double p_times_p_minus_a_times_p_minus_b = mul.apply(p_times_p_minus_a).apply(p_minus_b);

        // Шаг 8: Вычисление p * (p - a) * (p - b) * (p - c)
        double p_times_p_minus_a_times_p_minus_b_times_p_minus_c = mul.apply(p_times_p_minus_a_times_p_minus_b).apply(p_minus_c);

        // Шаг 9: Вычисление площади треугольника по формуле Герона
        double area = sqrt.apply(p_times_p_minus_a_times_p_minus_b_times_p_minus_c);

        return area;
    }
}
