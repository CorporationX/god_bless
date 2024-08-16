package faang.school.godbless.BJS2_20534;

import java.util.Arrays;
import java.util.function.Function;

public class Main {
    private static final String EXCEPTION_MESSAGE = " The sum of the lengths of two sides must be greater than the length of the third side";
    private Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    private Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
    private Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
    private Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
    private Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

    public Double triangleArea(double a, double b, double c) {
        checkTriangle(a, b, c);
        double perimeter = sum.apply(sum.apply(a).apply(b)).apply(c);
        double halfPerimeter = div.apply(perimeter).apply(2.0);
        double halfPerimeterMinusA = sub.apply(halfPerimeter).apply(a);
        double halfPerimeterMinusB = sub.apply(halfPerimeter).apply(b);
        double halfPerimeterMinusC = sub.apply(halfPerimeter).apply(c);
        double multiplication = multiplyNumbers(halfPerimeter, halfPerimeterMinusA, halfPerimeterMinusB, halfPerimeterMinusC);
        return sqrt.apply(multiplication);
    }

    public static void main(String[] args) {
        Main application = new Main();
        System.out.println(application.triangleArea(1, 1, 1));
    }

    private void checkTriangle(double a, double b, double c) {
        if (a >= sum.apply(b).apply(c)) {
            throw new IllegalArgumentException("Side A is wrong!" + EXCEPTION_MESSAGE);
        } else if (b >= sum.apply(a).apply(c)) {
            throw new IllegalArgumentException("Side B is wrong!" + EXCEPTION_MESSAGE);
        } else if (c >= sum.apply(a).apply(b)) {
            throw new IllegalArgumentException("Side C is wrong!" + EXCEPTION_MESSAGE);
        }
    }

    private double multiplyNumbers(double... nums) {
        return Arrays.stream(nums).reduce(1.0, (result, num) -> mul.apply(result).apply(num));
    }
}
