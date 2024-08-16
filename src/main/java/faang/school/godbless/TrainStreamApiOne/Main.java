package faang.school.godbless.TrainStreamApiOne;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = List.of("abaddon", "kunkka", "pudge", "anti-mage", "oracle", "dire-creep", "radiant-creep");

        int evenSum = integers.stream().filter(integer -> integer % 2 == 0).reduce(0, Integer::sum);

        System.out.println("even summ: " + evenSum);

        System.out.print("max num: ");
        integers.stream().max(Comparator.comparingInt(integer -> integer)).ifPresent(System.out::println);

        int medium = integers.stream().reduce(0, Integer::sum) / integers.size();
        System.out.println("medium: " + medium);

        int startedWith = (int) strings.stream().filter(string -> string.startsWith("a")).count();
        System.out.println("started with a: " + startedWith);

        List<String> containsSub = strings.stream().filter(string -> string.contains("creep")).toList();
        System.out.println("contains sub: " + containsSub.size());

        List<String> sortedByLength = strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println("sorted by length: " + sortedByLength.size());
        sortedByLength.forEach(System.out::println);
        System.out.println("____________");

        boolean isAllFine = strings.stream().allMatch(string -> string.length() > 6);
        System.out.println("isAllFine: " + isAllFine);

        int bottom = 4;
        int minNumAfterBottom = integers.stream().filter(integer -> integer > bottom).min(Comparator.naturalOrder()).get();
        System.out.println("minNumAfterBottom: " + minNumAfterBottom);

        List<Integer> stringsSizes = strings.stream().map(String::length).toList();
        System.out.println("stringsSizes: ");
        stringsSizes.forEach(System.out::println);

    }
}
