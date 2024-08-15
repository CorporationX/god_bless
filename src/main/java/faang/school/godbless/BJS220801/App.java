package faang.school.godbless.BJS220801;

import java.util.function.Function;
/**
Условия задачи
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

Можно пользоваться только данными лямбдами. Нельзя использовать арифметические операторы

+ - * / и пакет Math, и др.

Добавить валидацию входных параметров.
 */
public class App {

    public static void main(String[] args) {
        System.out.println(triangleArea(6, 8, 10)); // 24
    }

    private static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        // halfPerimeter = (a + b + c) / 2
        double halfPerimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply((2.0));
        // area = sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c))
        return sqrt.apply(mul.apply(mul.apply(mul.apply(halfPerimeter).apply(sub.apply(halfPerimeter).apply(a))).apply(sub.apply(halfPerimeter).apply(b))).apply(sub.apply(halfPerimeter).apply(c)));
    }
}
