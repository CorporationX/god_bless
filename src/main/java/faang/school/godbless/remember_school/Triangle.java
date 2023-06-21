package faang.school.godbless.remember_school;

import java.util.function.Function;

public class Triangle {
    Double triangleArea(double a, double b, double c) {
        if(a <= 0 || b <=0 || c <=0 || a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("Triangle cannot exist");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double pDiv2 = div.apply(sum.apply(a).apply(sum.apply(b).apply(c))).apply(2.0);
        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);
        double area = sqrt.apply(mul.apply(mul.apply(mul.apply(pDiv2).apply(pDiv2MinusA)).apply(pDiv2MinusB)).apply(pDiv2MinusC));
        return area;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle.triangleArea(6.0, 8.0, 10.0));

    }
}
