package faang.school.godbless.BJS2_20587;

import java.util.function.Function;

public class AreaCalculationService {

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a >= b + c || b >= a + c || c >= b + a) {
            throw new IllegalArgumentException("Invalid area");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        Double perimeter = sum.apply(a).apply(b);
        perimeter = sum.apply(perimeter).apply(c);

        Double halfMeter = div.apply(perimeter).apply(2.0);

        Double halfMeterMinusA = (sub.apply(halfMeter).apply(a)),
                halfMeterMinusB = (sub.apply(halfMeter).apply(b)),
                halfMeterMinusC = (sub.apply(halfMeter).apply(c));

        Double multiplication = mul.apply(halfMeter).apply(halfMeterMinusA);
        multiplication = mul.apply(multiplication).apply(halfMeterMinusB);
        multiplication = mul.apply(multiplication).apply(halfMeterMinusC);

        return sqrt.apply(multiplication);
    }
}
