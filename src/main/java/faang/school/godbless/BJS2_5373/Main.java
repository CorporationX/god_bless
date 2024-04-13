package faang.school.godbless.BJS2_5373;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        try {

        System.out.println(triangleArea(3.0, 4.0, 5.0));
        } catch (IllegalArgumentException e) {
            System.out.println(e + ": считаем площадь треугольника");
        }
    }

    // Даны три стороны треугольника, вычислить его площадь
    private static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if ((a + b < c) || (a + c < b) || (c + b < a)) {
            throw new IllegalArgumentException("такого треугольника не существует");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        Double pDiv2 = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        Double pDivMinusA = sub.apply(pDiv2).apply(a);
        Double pDivMinusB = sub.apply(pDiv2).apply(b);
        Double pDivMinusC = sub.apply(pDiv2).apply(c);
        Double mulPdivA = mul.apply(pDiv2).apply(pDivMinusA);
        Double mulPdivAB = mul.apply(mulPdivA).apply(pDivMinusB);
        Double mulPdivABC = mul.apply(mulPdivAB).apply(pDivMinusC);
        return sqrt.apply(mulPdivABC);
    }
}
