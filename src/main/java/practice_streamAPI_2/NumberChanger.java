package practice_streamAPI_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class NumberChanger {

    public void findTwoNumber(List<Integer> integerList, int sum) {
        checkOpportunityPairs(integerList, sum);
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> number = new HashSet<>(integerList);

        pairs = integerList.stream()
                .filter(num -> number.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());

        System.out.println(pairs);
    }

    public List<String> sorterCapital(Map<String, String> capitalCities) {
        return capitalCities.values().stream()
                .sorted()
                .toList();
    }

    public List<String> filterSortString(List<String> stringList, char symbol) {
        return stringList.stream()
                .filter(string -> string.toLowerCase().charAt(0) == Character.toLowerCase(symbol))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> converterBinary(List<Integer> integerList) {
        return integerList.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterAlphabetLength(List<String> stringList, String alphabet) {
        String pattern = "[" + alphabet + "].+";

        return stringList.stream()
                .filter(string -> string.matches(pattern))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private void checkOpportunityPairs(List<Integer> list, int sum) {
        checkListIsEmptyNotNull(list);

        int max = list.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("Лист не должен быть пустым!"));
        if (max * 2 < sum) {
            throw new IllegalArgumentException("Число слишком велико что бы подсчитать возможные варианты пар чисел из данного спика ");
        }
    }

    private void checkListIsEmptyNotNull(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Лист не должен быть null или пустым!");
        }
    }
}
