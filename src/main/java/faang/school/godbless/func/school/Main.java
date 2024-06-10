package faang.school.godbless.func.school;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Double area = calculateTriangleArea(3, 4, 5);
        System.out.println(area);
    }

    static Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;
        double semiPerimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        double firstSubtraction = sub.apply(semiPerimeter).apply(a);
        double secondSubtraction = sub.apply(semiPerimeter).apply(b);
        double thirdSubtraction = sub.apply(semiPerimeter).apply(c);
        return sqrt.apply(mul.apply(mul.apply(mul.apply(semiPerimeter).apply(firstSubtraction)).apply(secondSubtraction)).apply(thirdSubtraction));
    }
}
