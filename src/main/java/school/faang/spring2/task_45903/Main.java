package school.faang.spring2.task_45903;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println(triangleArea(6.0, 6.0, 4.0));
    }

    private static double triangleArea(double a, double b, double c) {
        Function<Double, Function<Double, Double>> add = x -> y -> x + y;
        Function<Double, Function<Double, Double>> div = x -> y -> x / y;
        Function<Double, Function<Double, Double>> sub = x -> y -> x - y;
        Function<Double, Function<Double, Double>> mul = x -> y -> x * y;

        if (add.apply(a).apply(b) <= c
                || add.apply(a).apply(c) <= b
                || add.apply(b).apply(c) <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не может существовать");
        }


        double perimeter = calculatePerimeter(a, b, c, add);
        double halfPerimeter = calculateHalfPerimeter(perimeter, div);

        double subA = sub.apply(halfPerimeter).apply(a);
        double subB = sub.apply(halfPerimeter).apply(b);
        double subC = sub.apply(halfPerimeter).apply(c);

        double mulabcandP = mul.apply(
                mul.apply(
                        mul.apply(halfPerimeter).apply(subA)
                ).apply(subB)
        ).apply(subC);

        return sqrt(mulabcandP);
    }

    private static double sqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Квадратный корень из отрицательного числа невозможен");
        }

        double guess = number / 2.0;

        while (Math.abs(guess * guess - number) > 0.00000001) {
            guess = (guess + number / guess) / 2.0;
        }

        return guess;
    }

    private static double calculateHalfPerimeter(double perimeter,
                                                 Function<Double, Function<Double, Double>> div) {
        return div.apply(perimeter).apply(2.0);
    }

    private static double calculatePerimeter(double a, double b, double c,
                                             Function<Double, Function<Double, Double>> sum) {
        // a + b + c
        double ab = sum.apply(a).apply(b);
        return sum.apply(ab).apply(c);
    }
}
