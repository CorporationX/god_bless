package faang.school.godbless.stream.api;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class StreamsString {
    public static long findNumberLineWithSymbol(List<String> listLine, char character) {
        Function<Character, String> convertCharacterToString = ch -> ch.toString().toUpperCase();
        String letter = convertCharacterToString.apply(character);
        return listLine.stream()
                .filter(String -> String.startsWith(letter))
                .count();
    }

    public static List<String> findLineWithSubstring(List<String> stringList, String substring) {
        return stringList.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(s -> s.length()))
                .toList();
    }

    public static boolean checkSatisfactionCondition(List<String> stringList) {
        return stringList.stream()
                .allMatch(s -> s.length() > 4);
    }

    private static Optional<String> findTheSmallestElement(List<String> stringList, int number) {
        return stringList.stream()
                .filter(a -> a.length() > number)
                .min(Comparator.comparingInt(String::length));
    }

    public static void processingOptional(List<String> stringList, int number) {
        Optional<String> optionalS = findTheSmallestElement(stringList, number);
        optionalS.ifPresentOrElse(System.out::println,
                () -> System.out.println("Нет такой строки"));
    }

    public static List<Integer> convertToListOfLength(List<String> stringList) {
        return stringList.stream()
                .map(a -> a.length())
                .toList();
    }
}
