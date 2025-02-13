package school.faang.sprint.second.streamapisecond;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
public abstract class Operations {
    public static void unique(Set<Integer> numbers, int sum) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        numbers.forEach(num -> numbers.stream()
                .filter(number -> !Objects.equals(number, num))
                .filter(number -> number + num == sum)
                .filter(number -> !Objects.equals(resultMap.get(number), num))
                .forEach(number -> resultMap.put(num, number)));

        log.info(resultMap.toString());
    }

    public static void sortMap(Map<String, String> countryMap) {
        List<String> countriesCapital = countryMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();

        log.info(countriesCapital.toString());
    }

    public static void sortList(List<String> list, char symbol) {
        List<String> sortedList = list.stream()
                .filter(word -> word.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.naturalOrder())
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        log.info(sortedList.toString());
    }

    public static void convertListElementToBinary(List<Integer> list) {
        List<String> binaryList = list.stream()
                .map(Integer::toBinaryString)
                .toList();

        log.info(binaryList.toString());
    }

    public static void filterAndSortList(List<String> strings, String alphabet) {
        List<String> filteredAndSortedList = strings.stream()
                .filter(word -> {
                    List<String> splitWord = Arrays.asList(word.split(""));
                    return splitWord.stream().allMatch(alphabet::contains);
                })
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        log.info(filteredAndSortedList.toString());
    }
}
