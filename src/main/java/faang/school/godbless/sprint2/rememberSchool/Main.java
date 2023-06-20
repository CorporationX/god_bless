package faang.school.godbless.sprint2.rememberSchool;

import java.util.function.Function;

import static java.lang.Math.sqrt;

public class Main {


    public static void main(String[] args) {

        System.out.println(triangleArea(5, 10, 10));

    }

    public static Double triangleArea(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Число не может быть отрецательным или равно 0");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> sqrt(x);
        double halfOfTriangle = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        double pDiv2MinusA = sub.apply(halfOfTriangle).apply(a);
        double pDiv2MinusB = sub.apply(halfOfTriangle).apply(b);
        double pDiv2MinusC = sub.apply(halfOfTriangle).apply(c);

        return sqrt.apply(mul.apply(mul.apply(mul.apply(halfOfTriangle).apply(pDiv2MinusA)).apply(pDiv2MinusB)).apply(pDiv2MinusC));
    }


}
