package faang.school.godbless;

import lombok.val;

import java.util.function.Function;
import java.util.function.Supplier;

public class Application {

    public static final double INITIAL_VALUE = 0.0;

    public static void main(String[] args) {

        System.out.println("God Bless! " + triangleArea(2, 2, 2));
    }

    // Даны три стороны треугольника, вычислить его площадь
    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        // Проверка, могут ли стороны образовать треугольник
        if (!(a + b > c && a + c > b && b + c > a)) {
            throw new IllegalArgumentException();
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        val poluPerimetr = div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0);
        // Вычисление площади по формуле Герона

//        double area = Math.sqrt(poluPerimetr * (poluPerimetr - a) * (poluPerimetr - b) * (poluPerimetr - c));

        val subA = (sub.apply(poluPerimetr).apply(a));
        val subB = (sub.apply(poluPerimetr).apply(b));
        val subC = (sub.apply(poluPerimetr).apply(c));
        val mult = mul.apply(mul.apply(mul.apply(poluPerimetr).apply(subA)).apply(subB)).apply(subC);
        val sqr = sqrt.apply(mult);

        // Output the result
        System.out.println("Semi-Perimeter: " + poluPerimetr);
        return sqr;
    }
}