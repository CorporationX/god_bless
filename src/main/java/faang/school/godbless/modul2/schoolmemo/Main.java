package faang.school.godbless.modul2.schoolmemo;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double result = triangleArea(3, 4, 5);
        System.out.println(result);

        try {
            triangleArea(30, 4, 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            triangleArea(0, 4, 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        paramsCheck(a, b, c);

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        //SemiPerimeter = (a + b + c) / 2
        double sp = sum.apply(sum.apply(a).apply(b)).apply(c);
        sp = div.apply(sp).apply(2.0);

        //S = sp(sp - a)(sp - b)(sp - c)
        double spSubA = sub.apply(sp).apply(a);
        double spSubB = sub.apply(sp).apply(b);
        double spSubC = sub.apply(sp).apply(c);

        double mul1 = mul.apply(sp).apply(spSubA);
        double mul2 = mul.apply(mul1).apply(spSubB);
        double mul3 = mul.apply(mul2).apply(spSubC);

        return sqrt.apply(mul3);
    }

    private static void paramsCheck(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("The sides of the triangle must be greater than 0");
        }

        if (a + b < c || a + c < b || c + b < a) {
            throw new IllegalArgumentException("One side of a triangle must not be greater than the sum of the other two sides");
        }
    }
}
