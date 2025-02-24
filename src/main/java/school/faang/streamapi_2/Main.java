package school.faang.streamapi_2;

import java.util.*;


public class Main {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        System.out.println(
                findPairs(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)), 7));
        // Выход: [(1, 6), (2, 5), (3, 4)]

        System.out.println(
                filterByCapital(
                        new HashMap<>(Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin"))));
        //Выход: ["Berlin", "Moscow", "Washington"]

        System.out.println(
                filterBySymbolAndLength(new ArrayList<>(List.of("apple", "banana", "avocado", "apricot")), 'a'));
        //Выход: ["apple", "apricot", "avocado"]

        System.out.println(toBinary(new ArrayList<>(List.of(1, 2, 3, 4))));
        //Выход: ["1", "10", "11", "100"]

        System.out.println(
                sortByAlphabetAndLength(new ArrayList<>(List.of("apple", "banana", "cherry", "date", "fig", "grape"))));
        //Выход: ["fig", "date", "apple", "grape", "banana", "cherry" ]
    }

    public static List<List<Integer>> findPairs(List<Integer> numbers, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int number1 : numbers) {
            if (isAlreadyExists(result, number1)) {
                continue;
            }
            List<Integer> pair = new ArrayList<>();
            numbers.forEach(number2 -> {
                if (number2 != number1) {
                    if (number2 + number1 == target) {
                        pair.add(number1);
                        pair.add(number2);
                    }
                }
            });
            result.add(pair);
        }
        return result;
    }

    private static boolean isAlreadyExists(List<List<Integer>> pairs, int target) {
        return pairs.stream().anyMatch(pair -> pair.contains(target));
    }

    public static List<String> filterByCapital(HashMap<String, String> map) {
        return map.values().stream().toList();
    }

    public static List<String> filterBySymbolAndLength(List<String> strings, Character character) {
        strings.stream().filter(str -> str.startsWith(character.toString())).toList();
        strings.sort(Comparator.comparingInt(String::length));
        return strings;
    }

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream().map(number -> {
            StringBuilder result = new StringBuilder();
            while (number != 0) {
                int remainder = number % 2;
                result = result.append(remainder);
                number /= 2;
            }
            result.reverse();
            return result.toString();
        }).toList();
    }

    public static List<String> sortByAlphabetAndLength(List<String> strings) {
        strings.stream().filter(str -> str.chars().allMatch(ch -> {
            for (Character letter : ALPHABET.toCharArray()) {
                if (letter == ch) {
                    return true;
                }
            }
            return false;
        })).toList();
        strings.sort(Comparator.comparingInt(String::length));
        return strings;
    }
}
