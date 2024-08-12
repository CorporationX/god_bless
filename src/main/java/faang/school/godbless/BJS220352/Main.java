package faang.school.godbless.BJS220352;

import java.util.function.Function;

public class Main {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (sum.apply(a).apply(b) <= c || sum.apply(a).apply(c) <= b || sum.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }

        Double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        Double area = sqrt.apply(mul.apply(mul.apply(mul.apply(sub.apply(p).apply(a)).apply(sub.apply(p).apply(b))).apply(sub.apply(p).apply(c))).apply(p));

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
