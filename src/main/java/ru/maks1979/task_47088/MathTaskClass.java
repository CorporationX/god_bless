package ru.maks1979.task_47088;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MathTaskClass {

    public static int sumOfEven(List<Integer> listOfNums) {
        return listOfNums.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, (accumulate, current) -> (accumulate + current));
    }

    public static int maxOfNums(List<Integer> listOfNums) {
        return listOfNums.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Список чисел пуст"));
    }

    public static double arithmeticMean(List<Integer> listOfNums) {
        int sum = listOfNums.stream()
                .reduce(0, (accumulate, current) -> (accumulate + current));
        return (double) sum / listOfNums.size();
    }

    public static int sumOfStringsBeginsWith(List<String> listOfStrings, Character someChar) {
        long sum = listOfStrings.stream()
                .filter(number -> number
                        .startsWith(Character
                                .toString(someChar)))
                .count();
        return (int) sum;
    }

    public static List<String> stringContainsSomeString(List<String> listOfStrings, String someString) {
        return listOfStrings.stream()
                .filter(number -> number
                        .contains(someString))
                .toList();
    }

    public static List<String> stringLength(List<String> listOfStrings) {
        return listOfStrings.stream()
                .sorted(Comparator
                        .comparingInt(String::length))
                .toList();
    }

    public static boolean stringSort(List<Integer> listOfNums, Predicate<Integer> somePredicate) {
        return listOfNums.stream()
                .allMatch(somePredicate);
    }

    public static int minOfNums(List<Integer> listOfNums, int someInt) {

        return listOfNums.stream()
                .min(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static List<Integer> listOfLongs(List<String> listOfStrings) {
        return listOfStrings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}//
