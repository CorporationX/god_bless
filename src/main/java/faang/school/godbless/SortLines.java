package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Set<Character> alphabetSet = convertToChar(alphabet);

        List<String> lines = Arrays.asList(
                "apple",
                "banana",
                "cat",
                "123",
                "dog"
        );

        List<String> sortedLines = sortLines(lines, alphabetSet);
        sortedLines.forEach(System.out::println);
    }

    public static Set<Character> convertToChar(String s) {
        return s.chars().mapToObj(c -> Character.toLowerCase((char) c)).collect(Collectors.toSet());
    }

    public static List<String> sortLines(List<String> lines, Set<Character> alphabet) {
        List<String> result = lines.stream().filter(line -> hasLetterFromAlphabet(line, alphabet))
                .sorted((s1, s2) -> s1.length() - s2.length()).collect(Collectors.toList());
        return result;
    }

    private static boolean hasLetterFromAlphabet(String line, Set<Character> alphabet) {
        Set<Character> lineSet = convertToChar(line);
        lineSet.retainAll(alphabet);
        return !lineSet.isEmpty();
    }
}
