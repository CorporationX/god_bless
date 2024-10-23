package school.faang.bjs2_35278;

import java.util.*;
import java.util.stream.Collectors;

public class Operators {
    public static List<int[]> uniqPairs(int[] numbers, int target) {
        Set<Integer> numbersFromTheList = new HashSet<>();
        return Arrays.stream(numbers)
                .filter(number -> numbersFromTheList.add(target - number))
                .mapToObj(number -> new int[]{number, target - number})
                .filter(pair -> Arrays.stream(numbers).anyMatch(n -> n == pair[1]))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> countriesCapitals(Map<String, String> countriesCapitalMap) {
//        List<String> sortCoutries = new ArrayList<>(countriesCapitalMap.keySet());
//        Collections.sort(sortCoutries);
//
//        List<String> sortCapitals = new ArrayList<>();
//        for (String country : sortCoutries) {
//            sortCapitals.add(countriesCapitalMap.get(country));
//        }
        return countriesCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> sortedAndFiltered(List<String> listOfNames, char characterLookingFor) {
        return listOfNames.stream()
                .filter(s -> s.startsWith(String.valueOf(characterLookingFor)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filteredAndSorted(List<String> words, String alphabet) {
        Set<Character> characters = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        return words.stream()
                .filter(word -> word.chars().allMatch(c -> characters.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
