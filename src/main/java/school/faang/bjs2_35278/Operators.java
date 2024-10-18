package school.faang.bjs2_35278;

import java.util.*;
import java.util.stream.Collectors;

public class Operators {
    public static List<int[]> uniqPairs(int[] numbers, int target) {
        Set<Integer> numbersFromTheList = new HashSet<>();
        Set<String> uniqPairs = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int listNumbers : numbers) {
            int findMissingAmount = target - listNumbers;

            if (numbersFromTheList.contains(findMissingAmount)) {
                int[] pair = new int[]{Math.min(listNumbers, findMissingAmount), Math.max(listNumbers, findMissingAmount)};
                String pairString = pair[0] + " ; " + pair[1];

                if (!uniqPairs.contains(pairString)) {
                    result.add(pair);
                    uniqPairs.add(pairString);
                }
            }
            numbersFromTheList.add(listNumbers);
        }
        return result;
    }

    public static List<String> countriesCapitals(Map<String, String> countriesCapitalMap) {
        List<String> sortCoutries = new ArrayList<>(countriesCapitalMap.keySet());
        Collections.sort(sortCoutries);

        List<String> sortCapitals = new ArrayList<>();
        for (String country : sortCoutries) {
            sortCapitals.add(countriesCapitalMap.get(country));
        }
        return sortCapitals;
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
