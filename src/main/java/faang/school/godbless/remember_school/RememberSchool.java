package faang.school.godbless.remember_school;

import java.util.function.Function;

public class RememberSchool {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        if (a + b <= c || b + c <= a || c + a <= b) {
            throw new IllegalArgumentException("Треугольника с такими сторонами не существует");
        }

        Double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        Double subA = sub.apply(p).apply(a);
        Double subB = sub.apply(p).apply(b);
        Double subC = sub.apply(p).apply(c);

        return sqrt.apply(mul.apply(mul.apply(mul.apply(p).apply(subA)).apply(subB)).apply(subC));
    }

    public static void main(String[] args) {
        System.out.println(triangleArea(3, 5, 6));
    }
}
