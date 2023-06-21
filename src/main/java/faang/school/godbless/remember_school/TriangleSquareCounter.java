package faang.school.godbless.remember_school;

import java.util.function.Function;

public class TriangleSquareCounter {

    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        boolean isValid = isTriangle(a, b, c);
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double pDiv2 = div.apply(sum.apply(
                        sum.apply(a).apply(b))
                .apply(c))
                .apply(2.0);

        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);

        double multiplication = mul.apply(pDiv2).apply(mul.apply(mul.apply(pDiv2MinusA).apply(pDiv2MinusB))
                .apply(pDiv2MinusC));

        return sqrt.apply(multiplication);
    }

    private boolean isTriangle(double a, double b, double c){
        if (a + b > c || a + c > b || b + c > a) {
            return false;
        } else if (a == 0 || b == 0 || c == 0){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TriangleSquareCounter triangleSquareCounter = new TriangleSquareCounter();

        System.out.println(triangleSquareCounter.triangleArea(3, 5, 5));
    }
}
