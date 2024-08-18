package rememberSchool;

import java.util.function.Function;

public class Main{
    public static void main(String[] args) {
        System.out.println(triangleArea(8.34,3.34,7.23));
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double result =  mul.apply(a).apply(mul.apply(b).apply(c));
        return result;
    }


}
