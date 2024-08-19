package faang.school.godbless.BJS220352;

import java.util.function.Function;

public class Main {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (a + b <= c || a + c <= b || b + c <= a) { //сумма двух сторон должна быть больше третьей
            throw new IllegalArgumentException("Invalid triangle sides");
        }

        double perimeter = sum.apply(c).apply(sum.apply(a).apply(b));

        double halfPerimeter = div.apply(perimeter).apply(2.0);

        double subHalfPerimeterWithSideA = sub.apply(halfPerimeter).apply(a);
        double subHalfPerimeterWithSideB = sub.apply(halfPerimeter).apply(b);
        double subHalfPerimeterWithSideC = sub.apply(halfPerimeter).apply(c);

        double underSqrt = mul.apply(halfPerimeter).apply(subHalfPerimeterWithSideA);
        underSqrt = mul.apply(underSqrt).apply(subHalfPerimeterWithSideB);
        underSqrt = mul.apply(underSqrt).apply(subHalfPerimeterWithSideC);

        double area = sqrt.apply(underSqrt);

        return area;
    }

    public static void main(String[] args) {
        try {
            double a = 3.0;
            double b = 4.0;
            double c = 5.0;

            Double area = triangleArea(a, b, c);
            System.out.println("Area: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
