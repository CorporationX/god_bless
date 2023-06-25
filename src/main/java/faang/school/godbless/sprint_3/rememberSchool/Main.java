package faang.school.godbless.sprint_3.rememberSchool;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Double result = main.triangleArea(5, 10, 10);
        System.out.println(result);
    }

    public Double triangleArea(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Неравенство треугольника не выполняется.");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        double pDiv2 = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);

        return sqrt.apply(mul.apply(pDiv2).apply(mul.apply(mul.apply(pDiv2MinusA).apply(pDiv2MinusB)).apply(pDiv2MinusC)));
    }
}
