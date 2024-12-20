package school.faang.sprint2.task_47381;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    static List<List<Integer>> getListPairEqualsTarget(
            List<Integer> listOfNumbers,
            int target
    ) {
        // думал будет лучше решить через 2 pointers
        List<List<Integer>> result = new ArrayList<>();
        listOfNumbers.sort(Integer::compareTo);
        int p1 = 0;
        int p2 = listOfNumbers.size() - 1;
        while (p1 < p2) {
            if (listOfNumbers.get(p1) + listOfNumbers.get(p2) == target) {
                result.add(
                        List.of(
                                listOfNumbers.get(p1),
                                listOfNumbers.get(p2)
                        )
                );
                p1++;
                p2--;
            } else if (listOfNumbers.get(p1) + listOfNumbers.get(p2) > target) {
                p2--;
            } else {
                p1++;
            }
        }
        return result;
    }

    static List<String> sortCapitalsByCountries(Map<String, String> capitalsByCountry) {
        return capitalsByCountry.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    static List<String> filterAndSortByTarget(List<String> listOfWords, Character beggingTargetChar) {
        Stream<String> filteredWords = listOfWords.stream().filter((word) -> word.charAt(0) == beggingTargetChar);
        return filteredWords.sorted(Comparator.comparingInt(String::length)).toList();
    }

    static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    static List<String> filterAndSortByAlphabeticalAscOrder(List<String> initialList, String alphabet) {
        List<Character> alphabeticalList = new ArrayList<>();
        for (char c : alphabet.toLowerCase().toCharArray()) {
            if ('a' <= c && c <= 'z') {
                alphabeticalList.add(c);
            }
        }

        Stream<String> filteredList = initialList.stream().filter(filterByContainingCharPredicate(alphabeticalList));
        return filteredList.sorted(Comparator.comparingInt(String::length)).toList();
    }

    static Predicate<String> filterByContainingCharPredicate(
            List<Character> charactersList
    ) {
        return (name) -> {
            for (char c : name.toCharArray()) {
                if (!charactersList.contains(c)) {
                    return false;
                }
            }
            return true;
        };
    }

    public static void main(String[] args) {
        // 1 task
        List<Integer> listOfIntegers = new ArrayList(List.of(1, 2, 3, 4, 5, 6));
        System.out.println(getListPairEqualsTarget(listOfIntegers, 7));

        //2 task
        System.out.println(sortCapitalsByCountries(
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")
        ));

        //3 task
        System.out.println(
                filterAndSortByTarget(List.of("apple", "banana", "avocado", "apricot"), 'a')
        );

        //4 task
        System.out.println(convertToBinary(List.of(1, 2, 3, 4)));

        //5 task
        System.out.println(
                filterAndSortByAlphabeticalAscOrder(List.of(
                                "apple", "banana", "cherry", "date", "fig", "grape"),
                        "abcdefghijklmn"
                )
        );
    }

}

