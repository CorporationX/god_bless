package remember.school;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double a = 3, b = 3, c = 3;
        double S = triangleArea(a, b, c);
        System.out.printf("Площадь треугольника с сторонами %s, %s, %s равна: %s%n", a, b, c, S);
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Входные значения не могут быть меньше или равны нулю.");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        Double p = div.apply(
            sum.apply(sum.apply(a).apply(b)).apply(c)
        ).apply(2.0);

        Double subA = sub.apply(p).apply(a);
        Double subB = sub.apply(p).apply(b);
        Double subC = sub.apply(p).apply(c);

        return sqrt.apply(
            mul.apply(mul.apply(p).apply(subA)).apply(mul.apply(subB).apply(subC))
        );
    }
}
