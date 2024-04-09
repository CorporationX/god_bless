package faang.school.godbless.remember_school;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class Main {

    public static void main(String[] args) {

        try {
            System.out.println(triangleArea(1, 2, 3));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }

        System.out.println(triangleArea(3, 4, 5));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {

        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new IllegalArgumentException("Each side must be greater than the sum of the other sides");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        Double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        Double pSubtractA = sub.apply(p).apply(a);
        Double pSubtractB = sub.apply(p).apply(b);
        Double pSubtractC = sub.apply(p).apply(c);
        Double s = sqrt.apply(mul.apply(mul.apply(mul.apply(p).apply(pSubtractA)).apply(pSubtractB)).apply(pSubtractC));

        return s;
    }
}