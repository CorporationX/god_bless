package faang.school.godbless;

import lombok.Getter;

import java.util.function.Function;

public class СalculatorArea {
    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a + b < c || b + c <= a || a + c <= b){
            throw new IllegalArgumentException("Треугольника с такими сторонами быть не может!");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        Double semiPerimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        Double deltaA = sub.apply(semiPerimeter).apply(a);
        Double deltaB = sub.apply(semiPerimeter).apply(b);
        Double deltaC = sub.apply(semiPerimeter).apply(c);

        return sqrt.apply(mul.apply(semiPerimeter).apply(mul.apply(deltaA).apply(mul.apply(deltaB).apply(deltaC))));
    }

    public static void main(String[] args) {
        СalculatorArea calc = new СalculatorArea();

        System.out.println("Площадь треугольника: " + calc.triangleArea(3.0, 4.0, 5.0));
    }
}
