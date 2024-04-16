package faang.school.godbless.backToSchool;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        double area = triangleArea(10, 10, 10);
        System.out.println(area);
    }
    // Даны три стороны треугольника, вычислить его площадь
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if(a+b<c || a+c<b || b+c<a ) throw new IllegalArgumentException("Triangle not exist");
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        double subPA = sub.apply(p).apply(a);
        double subPB = sub.apply(p).apply(b);
        double subPC = sub.apply(p).apply(c);

        double multipleAll = mul.apply(mul.apply(mul.apply(p).apply(subPA)).apply(subPB)).apply(subPC);
        return sqrt.apply(multipleAll);

    }

}