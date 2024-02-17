package faang.school.godbless.schoolToRemember;

import java.util.function.Function;

public class Main {
    public static void main(String... args) {
        System.out.println(triangleArea(5.0, 7.0, 3.0));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0 || a >= b + c || b >= a + c || c >= a + b) {
            throw new IllegalArgumentException("There can not be a triangle with that sizes!");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        Double perimeter = sum.apply(a).apply(sum.apply(b).apply(c));
        Double halfPerimeter = div.apply(perimeter).apply(2.0);
        return sqrt.apply(mul.apply(halfPerimeter).apply(mul.apply(sub.apply(halfPerimeter).apply(a)).apply(mul.apply(
                sub.apply(halfPerimeter).apply(b)).apply(
                sub.apply(halfPerimeter).apply(c)))));

    }
}
