package faang.school.godbless.school;

import java.util.function.Function;

public class Triangle {
    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        double pDiv2 = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);
        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);
        double result1 = mul.apply(pDiv2MinusA).apply(pDiv2MinusB);
        double result2 = mul.apply(pDiv2MinusC).apply(pDiv2);
        double resultFinal = sqrt.apply(
                mul.apply(
                        result1
                ).apply(result2)
        );

        //Округляем до 2-х знаков
        double scale = Math.pow(10, 2);
        double result = Math.ceil(resultFinal * scale) / scale;
        return result;
    }
}
