package faang.school.godbless.BJS2_20497;

import java.util.function.Function;

public class calculatingAreaTriangle {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new IllegalArgumentException("Invalid area");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        // по формуле S = √p · (p — a)(p — b)(p — c)
        double perimeter = sum.apply(a).apply(b);
        perimeter = sum.apply(perimeter).apply(c);  // находим периметр, чтоб в будущем найти полупериметр
        double semiperimeter = div.apply(perimeter).apply(2.0); // полупермитр

        double semiPerimeterMinusA = sub.apply(semiperimeter).apply(a); // момент (p — a)
        double semiPerimeterMinusB = sub.apply(semiperimeter).apply(b); // момент (p — b)
        double semiPerimeterMinusC = sub.apply(semiperimeter).apply(c); // момент (p — c)

        double semiperimeterMulA = mul.apply(semiperimeter).apply(semiPerimeterMinusA); // p · (p — a) полупериметр умножаем на (p - a)
        double semiperimeterMulB = mul.apply(semiperimeterMulA).apply(semiPerimeterMinusB); // предыдущее значение умножаем на (p — b)
        double semiperimeterMulC = mul.apply(semiperimeterMulB).apply(semiPerimeterMinusC); // предыдущее значение умножаем на (p — c)

        double area = sqrt.apply(semiperimeterMulC); // semiperimeterMulC под корнем, это и будет нашей площадью
        return area;
    }
}
