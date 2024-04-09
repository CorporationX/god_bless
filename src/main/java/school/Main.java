package school;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(5,6,7));
    }

    // Даны три стороны треугольника, вычислить его площадь
    private static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("Неверно введены стороны треугольника");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        // √((p*(p-a)*(p-b)*(p-c))
        double perimeter = sum.apply(a).apply(sum.apply(b).apply(c));
        double halfPerimeter = div.apply(perimeter).apply(2.0);

        double firstBrackets = sub.apply(halfPerimeter).apply(a);
        double secondBrackets = sub.apply(halfPerimeter).apply(b);
        double thirdBrackets = sub.apply(halfPerimeter).apply(c);

        double mulRes = mul.apply(halfPerimeter).apply(mul.apply(firstBrackets).apply(mul.apply(secondBrackets).apply(thirdBrackets)));
        return sqrt.apply(mulRes);
    }
}
