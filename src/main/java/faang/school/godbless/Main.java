package faang.school.godbless;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(3,4,5));
    }
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        if (a + b < c) {
            throw new IllegalArgumentException("sum of first and seconds sides must be greater than third side");
        } else if (a + c < b) {
            throw new IllegalArgumentException("sum of first and third sides must be greater than second side");
        } else if (b + c < a) {
            throw new IllegalArgumentException("sum of second and third sides must be greater than first side");
        }

        Double halfperimetr =  div.apply(sum.apply(sum.apply(b).apply(c)).apply(a)).apply(2.0);
        Double hPerimeterA = sub.apply(halfperimetr).apply(a);
        Double hPerimeterB = sub.apply(halfperimetr).apply(b);
        Double hPerimeterC = sub.apply(halfperimetr).apply(c);

        Double product = mul.apply(mul.apply(mul.apply(hPerimeterA).apply(hPerimeterB)).apply(hPerimeterC)).apply(halfperimetr);
        Double square = sqrt.apply(product);
        return square;
    }

}
