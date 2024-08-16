package remember_school;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(3,4,5));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        validTriangle(a, b, c);
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double p = mul.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(0.5);
        double pSubA = sub.apply(p).apply(a);
        double pSubB = sub.apply(p).apply(b);
        double pSubC = sub.apply(p).apply(c);
        double underSqrt = mul.apply(
                mul.apply(
                        mul.apply(pSubA).apply(pSubB))
                .apply(pSubC))
                .apply(p);

        return sqrt.apply(underSqrt);
    }

    private static void validTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Сторона треугольника не может быть меньше 0");
        }
        if(a + b <= c || b + c <= a || a + c <= b) {
            throw new IllegalArgumentException("Такого треугольника не существует");
        }
    }


}
