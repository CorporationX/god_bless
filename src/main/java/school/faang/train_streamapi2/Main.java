package school.faang.train_streamapi2;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static List<String> getUniquePairs(@NonNull Set<Integer> initialSet, int aimNumber) {
        return initialSet.stream()
                .flatMap(num1 -> initialSet.stream()
                        .filter(num2 -> num1 + num2 == aimNumber && num1 < num2)
                        .map(num2 -> String.format("(%d, %d)", num1, num2)))
                .toList();
    }

    public static List<String> getCapitals(@NonNull Map<String, String> inputMap) {
        return inputMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> getIntegerToBinaryString(@NonNull List<String> listStrings, Character startCharacter) {
        return listStrings.stream().filter(s -> s.startsWith("" + startCharacter))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> getIntegerToBinaryString(@NonNull List<Integer> listInteger) {
        return listInteger.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> getFilteredWords(@NonNull List<String> listWords, @NonNull String alphabet) {
        return listWords.stream().filter(s ->
                        s.chars().allMatch(ch -> alphabet.indexOf(ch) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    @SuppressWarnings("checkstyle:LineLength")
    public static void main(String[] args) {
        System.out.println(getFilteredWords(List.of("apple", "banana", "avocado", "apricote"), "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(getIntegerToBinaryString(List.of("apple", "banana", "avocado", "apricote"), 'a'));
        System.out.println(getUniquePairs(Set.of(1, 2, 3, 4, 5, 6), 6));
        System.out.println(getCapitals(Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")));
        System.out.println(getIntegerToBinaryString(List.of(1, 2, 3, 4)));
    }
}
