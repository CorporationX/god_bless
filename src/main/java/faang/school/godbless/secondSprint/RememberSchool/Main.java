package faang.school.godbless.secondSprint.RememberSchool;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Incorrect triangle side value");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double semiPerimeter = sum.apply(sum.apply(a).apply(b)).apply(c) / 2;
        double firstArg = sub.apply(semiPerimeter).apply(a);
        double secondArg = sub.apply(semiPerimeter).apply(b);
        double thirdArg = sub.apply(semiPerimeter).apply(c);
        double firstMulti = mul.apply(semiPerimeter).apply(firstArg);
        double secondMulti = mul.apply(secondArg).apply(thirdArg);

        return sqrt.apply(mul.apply(firstMulti).apply(secondMulti));
    }
}