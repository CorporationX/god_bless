package faang.school.godbless.backToSchool;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(5,4,3));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("wrong input mate");
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double temp = sum.apply(a).apply(b);
        double p = sum.apply(temp).apply(c);
        double semiP = div.apply(p).apply(2.0);

        double sMinusA = sub.apply(semiP).apply(a);
        double sMinusB = sub.apply(semiP).apply(b);
        double sMinusC = sub.apply(semiP).apply(c);
        double multi = mul.apply(semiP).apply(mul.apply(sMinusA).apply(mul.apply(sMinusB).apply(sMinusC)));

        return sqrt.apply(multi);
        }
    }

