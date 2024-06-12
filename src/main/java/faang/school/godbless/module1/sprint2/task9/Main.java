package faang.school.godbless.module1.sprint2.task9;

import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            if (isValid(a, b, c)) {
                System.out.println(triangleArea(a, b, c));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + " Don't do that!");
        }
    }

    // Даны три стороны треугольника, вычислить его площадь
    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;
        //S = √(p * (p - a) * (p - b) * (p - c))
        Double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        Double firstPat = mul.apply(p).apply(sub.apply(p).apply(a));
        Double secondPat = mul.apply(firstPat).apply(sub.apply(p).apply(b));
        Double thirdPat = mul.apply(secondPat).apply(sub.apply(p).apply(c));
        return sqrt.apply(thirdPat);
    }

    public static boolean isValid(Double a, Double b, Double c) {
        return a + b > c && b + c > a && a + c > b;
    }
}
