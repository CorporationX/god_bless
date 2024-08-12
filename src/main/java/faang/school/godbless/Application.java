package faang.school.godbless;

import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        System.out.println(triangleArea(5,4,3));
    }

    // Даны три стороны треугольника, вычислить его площадь
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        if (a > 0 && b > 0 && c > 0)
        {
            double temp = sum.apply(a).apply(b);
            double P = sum.apply(temp).apply(c);
            double semiP = div.apply(P).apply(2.0);

            double sMinusA = sub.apply(semiP).apply(a);
            double sMinusB = sub.apply(semiP).apply(b);
            double sMinusC = sub.apply(semiP).apply(c);

            double multi = mul.apply(semiP).apply(mul.apply(sMinusA).apply(mul.apply(sMinusB).apply(sMinusC)));

            return sqrt.apply(multi);
        }
        throw new IllegalArgumentException("wrong input mate");
    }
}