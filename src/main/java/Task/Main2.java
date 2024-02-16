package Task;
import java.util.function.Function;

public class Main2 {
    // Даны три стороны треугольника, вычислить его площадь
    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0 || a > c+b || b > a+c || c> a+b) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными числами и одна сторона не может превышать сумму двух других сторон");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        // Полупериметр треугольника
        double halfPerimeter = div.apply(sum.apply(
                                sum.apply(a).apply(b))
                        .apply(c))
                .apply(2.0);

        double pDiv2MinusA = sub.apply(halfPerimeter).apply(a);
        double pDiv2MinusB = sub.apply(halfPerimeter).apply(b);
        double pDiv2MinusC = sub.apply(halfPerimeter).apply(c);
        // Формула Герона для вычисления площади треугольника
        double area = sqrt.apply(
                mul.apply(halfPerimeter).apply(mul.apply(pDiv2MinusA).apply(mul.apply(pDiv2MinusB).apply(pDiv2MinusC))));
        return area;
    }

    public static void main(String args[]) {
        try {
            double a = 66.0;
            double b = 55.0;
            double c = 44.0;

            double result = triangleArea(a, b, c);
            System.out.println("Площадь треугольника: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}