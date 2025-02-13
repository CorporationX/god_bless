package school.faang.task58236.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListOperations {
    public int summaChet(List<Integer> numb) {
        int result = 0;
        result = numb.stream()
                .filter((num) -> num % 2 == 0)
                .reduce(0, Integer::sum);
        return result;
    }

    public int maxElement(List<Integer> numb) {
        int result = 0;
        result = numb.stream()
                .max(Integer::compareTo).orElse(0);
        return result;
    }

    public double midElement(List<Integer> numb) {
        return numb.stream()
                .mapToDouble(value -> (double) value)
                .average()
                .orElse(0.0);
    }

    public long findStartChar(List<String> strings, char startSymbol) {
        return strings.stream()
                .filter(startCh -> startCh.charAt(0) == startSymbol)
                .count();
    }

    public List<String> findSubString(List<String> strings, String subString) {
        List<String> result = strings.stream()
                .map(String::toLowerCase)
                .filter(subStr -> subStr.contains(subString))
                .toList();
        return result;
    }

    public List<String> sortToLength(List<String> strings) {
        return strings.stream()
                .sorted((Comparator.comparingInt(String::length)))
                .toList();
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию.
    //
    //Метод должен принимать список чисел и предикат, возвращать true, если все элементы списка удовлетворяют условию.
    //
    //Вход: List<Integer>, Predicate<Integer>, выход: boolean.




}