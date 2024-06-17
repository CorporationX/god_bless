package faang.school.godbless.lambda.triangleArea;

import java.util.function.Function;

public class Main {

    public static Double triangleSquare(Double a, Double b, Double c) {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        if (!isTriangle(a, b, c)) {
            throw new IllegalArgumentException("Not a triangle, a = " + a + ", b = " + b + ", c = " + c);
        }

        double sumAB = sum.apply(a).apply(b);
        double perimeter = sum.apply(sumAB).apply(c);
        double halfPerimeter = div.apply(perimeter).apply(2.0);

        double halfPerimeterSubA = sub.apply(halfPerimeter).apply(a);
        double halfPerimeterSubB = sub.apply(halfPerimeter).apply(b);
        double halfPerimeterSubC = sub.apply(halfPerimeter).apply(c);

        double multipleAB = mul.apply(halfPerimeterSubA).apply(halfPerimeterSubB);
        double multipleABC = mul.apply(multipleAB).apply(halfPerimeterSubC);
        double multiplePABC = mul.apply(halfPerimeter).apply(multipleABC);

        return sqrt.apply(multiplePABC);
    }

    private static boolean isTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static void main(String[] args) {
        System.out.println(triangleSquare(3.0, 4.0, 5.0));
    }
}
