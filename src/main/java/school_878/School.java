package school_878;

import java.util.function.Function;

public class School {
    public static void main(String[] args) {
        System.out.println("Площадь треугольника = " + triangleArea(3, 4, 5));
    }

    // Даны три стороны треугольника, вычислить его площадь
    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        Double square = null;

        if ((a + b > c) && (b + c > a) && (a + c > b)) {
                    Double perimeter = div.apply(sum.apply(a).andThen(sum.apply(b)).apply(c)).apply(2D);
                    Double sumDivPerimeter = sum.apply(sub.apply(perimeter).apply(a)).andThen(sum.apply(sub.apply(perimeter).apply(b))).apply(sub.apply(perimeter).apply(c));
                    Double mult = mul.apply(perimeter).apply(sumDivPerimeter);
                    square = sqrt.apply(mult);
                } else throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        return square;
    }
}