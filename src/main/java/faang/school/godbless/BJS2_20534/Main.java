package faang.school.godbless.BJS2_20534;


import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    private static final String EXCEPTION_MESSAGE = " The sum of the lengths of two sides must be greater than the length of the third side";

    public Double triangleArea(double a, double b, double c) {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (a > sum.apply(b).apply(c)) {
            throw new IllegalArgumentException("Side A is wrong!" + EXCEPTION_MESSAGE);
        } else if (b > sum.apply(a).apply(c)) {
            throw new IllegalArgumentException("Side B is wrong!" + EXCEPTION_MESSAGE);
        } else if (c > sum.apply(a).apply(b)) {
            throw new IllegalArgumentException("Side C is wrong!" + EXCEPTION_MESSAGE);
        }

        double perimeter = sum.apply(sum.apply(a).apply(b)).apply(c);
        double halfPerimeter = mul.apply(div.apply(1.0).apply(2.0)).apply(perimeter);
        double halfPerimeterMinusA = sub.apply(halfPerimeter).apply(a);
        double halfPerimeterMinusB = sub.apply(halfPerimeter).apply(b);
        double halfPerimeterMinusC = sub.apply(halfPerimeter).apply(c);
        return sqrt.apply(mul.apply(mul.apply(mul.apply(halfPerimeter).apply(halfPerimeterMinusA)).apply(halfPerimeterMinusB)).apply(halfPerimeterMinusC));
    }

    public static void main(String[] args) {
        Main application = new Main();
        System.out.println(application.triangleArea(3, 1, 1));
    }
}
