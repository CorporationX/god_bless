package faang.school.godbless.sprint3.lambda.task3;

import java.util.function.Function;

public class Triangle {

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Значения не могут быть 0 или меньше 0");
        }

        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new IllegalArgumentException("Такого треугольника не существует!");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double sumAB = sum.apply(a).apply(b);
        double sumABC = sum.apply(c).apply(sumAB);
        double p = div.apply(sumABC).apply(2.0);
        double pSubA = sub.apply(p).apply(a);
        double pSubB = sub.apply(p).apply(b);
        double pSubC = sub.apply(p).apply(c);
        double pMul1 = mul.apply(p).apply(pSubA);
        double pMul2 = mul.apply(pMul1).apply(pSubB);
        double pMul3 = mul.apply(pMul2).apply(pSubC);
        double result = sqrt.apply(pMul3);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(triangleArea(3.1, 5.4, 4.5));
    }
}
