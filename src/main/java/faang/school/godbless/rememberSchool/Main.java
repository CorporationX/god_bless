package faang.school.godbless.rememberSchool;

import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите три числа через запятую: ");
        String input = scanner.nextLine();

        String[] numbers = input.split(",");

        int number1 = Integer.parseInt(numbers[0].trim());
        int number2 = Integer.parseInt(numbers[1].trim());
        int number3 = Integer.parseInt(numbers[2].trim());

        if ((number1 + number2 > number3) && (number2 + number3 > number1) && (number1 + number3 > number2)) {
            System.out.println(triangleArea(number1, number2, number3));
        } else {
            System.out.println("Треугольника с такими сторонами не существует.");
        }
    }

    public static double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> {
            if (x < 0) {
                throw new IllegalArgumentException("Подкорневое число не может быть отрицательным");
            }
            return Math.sqrt(x);
        };
        double semiperimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);
        double semiperimeterMinusFirstSide = sub.apply(semiperimeter).apply(a);
        double semiperimeterMinusSecondSide = sub.apply(semiperimeter).apply(b);
        double semiperimeterMinusThirdSide = sub.apply(semiperimeter).apply(c);
        double areaOfTriangle = sqrt.apply(mul.apply(mul.apply((mul.apply(semiperimeter).apply(semiperimeterMinusFirstSide)))
                .apply(semiperimeterMinusSecondSide)).apply(semiperimeterMinusThirdSide));

        return areaOfTriangle;
    }
}