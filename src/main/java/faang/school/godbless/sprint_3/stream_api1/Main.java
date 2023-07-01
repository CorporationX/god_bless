package faang.school.godbless.sprint_3.stream_api1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public int calculateSumOfEvenNumbers(List<Integer> list) {
        listValidation(list);
        return list.stream()
                .filter(value -> value % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }

    public int findMaxElement(List<Integer> list) {
        listValidation(list);
        return list.stream()
                .max(Comparator.comparingInt(integer -> integer))
                .orElse(0);
    }

    public double findAverageValue(List<Integer> list) {
        listValidation(list);
        return list.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public List<String> searchWordsIn(List<String> stringList, char value) {
        listValidation(stringList);
        return stringList.stream()
                .filter(stroke -> stroke.charAt(0) == value)
                .toList();
    }

    public List<String> filterList(List<String> list, String substring) {
        listValidation(list);
        return list.stream()
                .filter(stroke -> stroke.contains(substring))
                .toList();
    }

    public List<String> filterByLength(List<String> list) {
        listValidation(list);
        return list.stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .toList();
    }

    public <T> boolean satisfyCondition(List<T> list, Predicate<T> predicate) {
        listValidation(list);
        return list.stream()
                .allMatch(predicate);
    }

    public int findSmallestElementAfterNumber(List<Integer> list, int value) {
        listValidation(list);
        return list.stream()
                .filter(number -> number > value)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public List<Integer> convertList(List<String> stringList) {
        listValidation(stringList);
        return stringList.stream().map(String::length).toList();
    }

    public <T> void listValidation(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Your list is Empty or null");
        }
    }
}
