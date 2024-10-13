package trainingStreamApiSecond;

import java.util.Arrays;
import java.util.Collections;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public static Set<List<Integer>> findUniqueNumbersPairsSumWhichEqualGoal(List<Integer> numbers, int goal) {
        return numbers.stream()
                .filter(number -> numbers.contains(goal - number))
                .map(number -> Arrays.asList(number, goal - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountryByAlphabetAndGetListAllCapital(Map<String, String> countryToCapitalMap) {
        return countryToCapitalMap.entrySet().stream()
                .sorted((o1, o2) -> {
                    return o1.getKey().charAt(0) - o2.getKey().charAt(0);
                })
                .map(entry -> entry.getValue())
                .toList();
    }

    public static List<String> filterStringByCharacterAndSortByLenght(List<String> list, char ch) {
        return list.stream()
                .filter(str -> str.charAt(0) == ch)
                .sorted((o1, o2) -> {
                    return o1.length() - o2.length();
                })
                .toList();
    }

    public static List<String> convertNumberToBinary (List<Integer> list) {
        return list.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterStringByAlphabetAndSortByLenght(List<String> list, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return list.stream()
                .filter(word -> word.matches(regex))
                .sorted((o1, o2) -> o1.length() - o2.length())
                .toList();
    }
}
