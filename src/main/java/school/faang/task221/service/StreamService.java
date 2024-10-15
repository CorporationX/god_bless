package school.faang.task221.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamService {

    public static int countEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int maxNumber(List<Integer> list) {
        if ((list.size()==0)){
            throw new RuntimeException("Список пуст");
        }
        return list.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static double avg(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static int countStringWithSimilarStart(List<String> list, String startWith) {
        return list.stream()
                .filter(n -> n.startsWith(startWith))
                .mapToInt((str) -> 1)
                .sum();
    }

    public static List<String> getStringWithSimilarStart(List<String> list, String startWith) {
        return list.stream()
                .filter(n -> n.startsWith(startWith))
                .collect(Collectors.toList());
    }

    public static List<String> sortByStringLeanth(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean checkPredicateForList(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream()
                .filter(predicate)
                .toList().size() == list.size();
    }

    public static int findSmallestNumber(List<Integer> list, int number) {
        if ((list.size()==0)){
            throw new RuntimeException("Список пуст");
        }

        return list.stream()
                .filter(listNumber -> listNumber > number)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static List<Integer> getListOfStringsSize(List<String> list) {
        return list.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

}
