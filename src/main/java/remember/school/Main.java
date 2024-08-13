package remember.school;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.printf("%nThe area of this triangle: %.4f%n", triangleArea(3, 4, 5));
        try{
            System.out.println(triangleArea(0, 1, 2));
        } catch (IllegalArgumentException e) {
            System.out.printf("%n%s%n",e.getMessage());
        }
        try {
            System.out.println(triangleArea(3, 6, 1));
        } catch (IllegalArgumentException e) {
            System.out.printf("%n%s%n",e.getMessage());
        }
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;
        validateTriangle(a, b, c);
        double halfPerimeter = div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0);
        double subHalfPerimeterWithSideA = sub.apply(halfPerimeter).apply(a);
        double subHalfPerimeterWithSideB = sub.apply(halfPerimeter).apply(b);
        double subHalfPerimeterWithSideC = sub.apply(halfPerimeter).apply(c);
        double underSqrt = mul.apply(mul.apply(mul.apply(subHalfPerimeterWithSideA)
                                        .apply(subHalfPerimeterWithSideB))
                                        .apply(subHalfPerimeterWithSideC))
                                        .apply(halfPerimeter);
        return sqrt.apply(underSqrt);
    }

    public static void validateTriangle(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Side can only be positive");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Sum of two sides must be bigger than third");
        }
    }
}
