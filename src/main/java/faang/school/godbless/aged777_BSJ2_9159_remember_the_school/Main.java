package faang.school.godbless.aged777_BSJ2_9159_remember_the_school;

import java.util.function.Function;

public class Main {
    /*

    Условия задачи:

    Дан код:

// Даны три стороны треугольника, вычислить его площадь
Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
}

Используя данные лямбды, вычислить площадь треугольника

Можно пользоваться только данными лямбдами. Нельзя использовать арифметические операторы + - * / и пакет Math, и др.

Добавить валидацию входных параметров.

     */
    public static void main(String[] args) {
        System.out.println(triangleArea(5, 6, 9));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        // площадь треугольника s = sqrt(p*(p-a)*(p-b)*(p-c)), где p - полупериметр, a, b, c - стороны

        double perimeter = sum.apply(a).apply(sum.apply(b).apply(c)); // perimeter
        double p = div.apply(perimeter).apply(2.0); // perimeter_half

        double pa = sub.apply(p).apply(a); // (p-a)
        double pb = sub.apply(p).apply(b); // (p-b)
        double pc = sub.apply(p).apply(c); // (p-c)

        double p_pa = mul.apply(p).apply(pa); // p*(p-a)
        double pb_pc = mul.apply(pb).apply(pc); // (p-b)*(p-c)

        double p_abc = mul.apply(p_pa).apply(pb_pc); // p*(p-a)*(p-b)*(p-c)

        return sqrt.apply(p_abc); // s = sqrt(p*(p-a)*(p-b)*(p-c))
    }
}
