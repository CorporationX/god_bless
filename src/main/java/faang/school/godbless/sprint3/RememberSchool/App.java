package faang.school.godbless.sprint3.RememberSchool;

import java.util.function.Function;

public class App {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (a >= b + c ||
            b >= a + c ||
            c >= a + b){
            throw new IllegalArgumentException("Треугольник не может существовать");
        }

        double perimeterDiv = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);

        double perimeterSubA = sub.apply(perimeterDiv).apply(a);
        double perimeterSubB = sub.apply(perimeterDiv).apply(b);
        double perimeterSubC = sub.apply(perimeterDiv).apply(c);

        return sqrt.apply(
                mul.apply(mul.apply(perimeterSubA).apply(perimeterSubB)).apply(mul.apply(perimeterDiv).apply(perimeterSubC))
        );

    }
}
