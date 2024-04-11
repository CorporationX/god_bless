package faang.school.godbless.functionalInterfaces.school;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Triangle area method testing beginning.");
        log.info("The result of calculating the area of a (a = 4, b = 3, c = 5) triangle\n: " + triangleArea(4, 3, 5));
        log.info("The result of calculating the area of a (a = 3, b = 3, c = 3) triangle\n: " + triangleArea(3, 3, 3));
        log.info("The result of calculating the area of a (a = 4, b = 5, c = 7) triangle\n: " + triangleArea(4, 5, 7));

        try {
            log.info("The result of calculating the area of a (a = 4, b = 30, c = 5) triangle\n: " + triangleArea(4, 30, 5));
        } catch (Exception e) {
            log.warn("Exception was caught during the operation of calculating the area of a (a = 4, b = 30, c = 5) triangle.");
            log.error("Exception message: " + e.getMessage());
        }

        try {
            log.info("The result of calculating the area of a (a = -4, b = -3, c = 5) triangle\n: " + triangleArea(-4, -3, 5));
        } catch (Exception e) {
            log.warn("Exception was caught during the operation of calculating the area of a (a = -4, b = -3, c = 5) triangle.");
            log.error("Exception message: " + e.getMessage());
        }

        try {
            log.info("The result of calculating the area of a (a = 4, b = 0, c = 5) triangle\n: " + triangleArea(4, 0, 5));
        } catch (Exception e) {
            log.warn("Exception was caught during the operation of calculating the area of a (a = 4, b = 0, c = 5) triangle.");
            log.error("Exception message: " + e.getMessage());
        }
    }

    // Даны три стороны треугольника, вычислить его площадь
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("All lengths of the sides of a triangle must be greater than zero!");
        }

        if (a + b < c || a + c < b || c + b < a) {
            throw new IllegalArgumentException("Two lengths of the sides of a triangle cannot be greater than third!");
        }


        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double p = sum.apply(sum.apply(a).apply(b)).apply(c); //semi perimeter
        p = div.apply(p).apply(2.0);

        double pMinusA = sub.apply(p).apply(a);
        double pMinusB = sub.apply(p).apply(b);
        double pMinusC = sub.apply(p).apply(c);

        double firstHalf = mul.apply(p).apply(pMinusA);
        double secondHalf = mul.apply(pMinusB).apply(pMinusC);

        double mainPart = mul.apply(firstHalf).apply(secondHalf);

        return sqrt.apply(mainPart);
    }
}
