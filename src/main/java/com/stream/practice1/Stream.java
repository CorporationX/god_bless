package com.stream.practice1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static int sumEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(y -> y % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxNumber(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    public static double avgNumbers(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public static long countLines(List<String> list) {
        return list.stream()
                .filter(s -> s.startsWith("I"))
                .count();
    }

    public static List<String> searchLines(List<String> list) {
        return list.stream()
                .filter(s -> s.contains("handle"))
                .collect(Collectors.toList());
    }

    public static List<String> sortedByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean isBoolean(List<String> list) {
        return list.stream()
                .allMatch(s -> s.contains("I"));
    }

    public static int minNumber(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num < 10)
                .min()
                .getAsInt();
    }

    public static List<Integer> lengthLines(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
