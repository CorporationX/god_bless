package faang.school.godbless.RememberSchool;

import java.util.function.Function;

public class Triangle {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        // Validate triangle
        if (sum.apply(a).apply(b) <= c || sum.apply(a).apply(c) <= b || sum.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("It's not a triangle");
        }

        // Heron's formula
        // triangle area = sqrt(s(s - a)(s - b)(s - c)) where s = (a + b + c)/2

        Double s = sum.apply(a).apply(b); // a + b
        s = sum.apply(s).apply(c); // a + b + c
        s = div.apply(s).apply(2.0); // (a + b + c) / 2

        Double value = mul.apply(s).apply(sub.apply(s).apply(a)); // s(s - a)
        value = mul.apply(value).apply(sub.apply(s).apply(b)); // s(s - a)(s - b);
        value = mul.apply(value).apply(sub.apply(s).apply(c)); // s(s - a)(s - b)(s - c);

        return sqrt.apply(value);
    }
}
