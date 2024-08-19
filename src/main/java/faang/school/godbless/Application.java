package faang.school.godbless;

import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");

        System.out.println(triangleArea(10.0, 6.0, 6.0));
    }

    private static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a)
        {
            throw new IllegalArgumentException("Неправильные стороны треугольника");
        }


        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double perimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        double outA = sub.apply(perimeter).apply(a);
        double outB = sub.apply(perimeter).apply(b);
        double outC = sub.apply(perimeter).apply(c);

        return sqrt.apply(mul.apply(perimeter).apply(mul.apply(mul.apply(outA).apply(outB)).apply(outC)));
    }
}