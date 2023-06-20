package faang.school.godbless.sprint3.school;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class School {
    private static final Logger LOGGER = LoggerFactory.getLogger(School.class);
    public Double triangleArea(double a, double b, double c) {
        if (a == 0 || b == 0 || c == 0) {
            LOGGER.error("Sides of a triangle cannot be zero");
        }
        if (a >= b + c || b >= a + c || c >= a + b) {
            LOGGER.error("Invalid input data");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double pDiv2 = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);
        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);

        return sqrt.apply(
                mul.apply(
                        mul.apply(pDiv2).apply(pDiv2MinusA)
                        ).apply(
                                mul.apply(pDiv2MinusB).apply(pDiv2MinusC)
                        )
        );
    }
}
