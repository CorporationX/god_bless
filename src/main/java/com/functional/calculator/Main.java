package com.functional.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listNumbers = List.of(2, 4, 6, 8);

        System.out.println(CalculatorUntil.sum(listNumbers));
        System.out.println(CalculatorUntil.product(listNumbers));
    }
}
