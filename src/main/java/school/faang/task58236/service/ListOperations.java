package school.faang.task58236.service;

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


}