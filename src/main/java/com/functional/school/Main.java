package com.functional.school;

import java.util.function.Function;

public class Main {


    public static void main(String[] args) {

        triangleArea(2, 3, 4);
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<String, String> s;
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        //Получаем полупериметр ((a + b + c) / 2)
        double halfMeter = div.apply(sum.apply(sum.apply(b).apply(c)).apply(a)).apply(2.0);
        System.out.println("halfMeter = " + halfMeter);

        // step1 = (полупериметр - a) * (полупериметр - b)
        double step1 = mul.apply(sub.apply(halfMeter).apply(a)).apply(sub.apply(halfMeter).apply(b));
        System.out.println("step1 = " + step1);

        // step2 = step1 * (полупериметр - c)
        double step2 = mul.apply(sub.apply(halfMeter).apply(c)).apply(step1);
        System.out.println("step2 = " + step2);

        // step3 = step2 * полупериметр
        double step3 = mul.apply(step2).apply(halfMeter);

        //square = корень из числа step3
        double square = sqrt.apply(step3);
        System.out.println("square = " + square);

        return square;
    }
}
