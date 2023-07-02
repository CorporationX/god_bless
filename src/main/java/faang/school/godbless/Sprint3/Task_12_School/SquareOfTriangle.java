package faang.school.godbless.Sprint3.Task_12_School;

import java.util.function.Function;

public class SquareOfTriangle {
    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {

        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new IllegalArgumentException("Сторона треугольника должна быть меньше суммы двух его других сторон");
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Сторона треугольника должна быть положительным числом");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double halfPerimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        double halfPerimeterSubtractA = sub.apply(halfPerimeter).apply(a);
        double halfPerimeterSubtractB = sub.apply(halfPerimeter).apply(b);
        double halfPerimeterSubtractC = sub.apply(halfPerimeter).apply(c);

        double multiplication = mul.apply(mul.apply(mul.apply(halfPerimeter).apply(halfPerimeterSubtractA)).apply(halfPerimeterSubtractB)).apply(halfPerimeterSubtractC);

        double square = sqrt.apply(multiplication);

        return square;
    }
    public static void main(String[] args) {
        System.out.println(triangleArea(5.25, 6.43, 4.74));
    }
}
