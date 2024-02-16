package src.main.java.faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<String> strings = Arrays.asList("Java", "Python", "JavaScript", "C++", "Ruby");
        Collections.addAll(list,1,2,3,4,5,6,7,8,9);
        int sum = list.stream()
                .filter(numbers -> numbers %2==0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        int max = list.stream()
                .max(naturalOrder())
                .get();
        System.out.println(max);

        OptionalDouble average = list.stream()
                .mapToInt(Integer::intValue)
                .average();
        System.out.println(average);

        long count = strings.stream()
                .filter(s -> s.startsWith("J"))
                .count();
        System.out.println(count);

        List<String> sorted_strings = strings.stream()
                .sorted(comparingInt(String::length))
                .toList();
        System.out.println(sorted_strings);

        boolean allMatch = strings.stream()
                .allMatch(s -> s.length() > 1);
        System.out.println(allMatch);

        int targetNumber = 5;
        Optional<String> string3 = strings.stream()
                .filter(s -> s.length() > targetNumber)
                .min(comparingInt(String::length));
        string3.ifPresent(System.out::println);

        List<Integer> lengths = strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(lengths);
    }
}
