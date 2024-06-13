package faang.school.godbless.BJS2_9152;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println(triangleArea(15,12,10));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        // полупериметр
        Double p = sum.apply(sum.apply(a).apply(b)).apply(c) / 2d;

        //разности
        Double difA = sub.apply(p).apply(a);
        Double difB = sub.apply(p).apply(b);
        Double difC = sub.apply(p).apply(c);

        // произведение
        Double difA_difB = mul.apply(difA).apply(difB);
        Double difA_difB_difC = mul.apply(difA_difB).apply(difC);
        Double p_difA_difB_difC = mul.apply(p).apply(difA_difB_difC);

        // Ответ
        Double S = sqrt.apply(p_difA_difB_difC);

        return S;
    }
}
