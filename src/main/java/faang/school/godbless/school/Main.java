package faang.school.godbless.school;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculateTriangleArea(7.0, 1.0, 13.0));
    }

    static Double calculateTriangleArea(double a, double b, double c) {
        validateTriangleSides(a, b, c);

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        Double perimeter = div.apply(sum.
                apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);   //sqrt(p * ( ((p-a) * (p-b)) * (p-c)) )
        Double area = sqrt.apply(mul.apply(perimeter).apply(
                mul.apply(mul.apply(sub.apply(perimeter).apply(a)).apply(sub.apply(perimeter).apply(b)))
                        .apply(sub.apply(perimeter).apply(c))));
        return area;
    }

    private static void validateTriangleSides(double a, double b, double c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны не должны быть меньше нуля и не должны равняться нулю");
        }
        if (a + b < c || a + c < b || c + b < a) {
            throw new IllegalArgumentException("Сумма сторон треугольника не может быть меньше третьей");
        }
    }
}

