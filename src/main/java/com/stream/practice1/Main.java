package com.stream.practice1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> listNumbers = List.of(1, 4, 6, 10, 23, 64, 23, 100);
        List<String> stringList = List.of("I am studying at a bootcamp",
                "I'll get a new job",
                "I can handle any difficulties");

        System.out.println(Stream.sumEvenNumbers(listNumbers));
        System.out.println(Stream.maxNumber(listNumbers));
        System.out.println(Stream.avgNumbers(listNumbers));
        System.out.println(Stream.countLines(stringList, 'I'));
        System.out.println(Stream.searchLines(stringList, "handle"));
        System.out.println(Stream.sortedByLength(stringList));
        System.out.println(Stream.isBoolean(stringList, 'I'));
        System.out.println(Stream.minNumber(listNumbers, 10));
        System.out.println(Stream.lengthLines(stringList));

    }
}
