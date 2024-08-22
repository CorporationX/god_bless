package faang.school.godbless;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfStringsStartingWithGivenLetter {
    public static List<String> stringList(List<String> list, char Startletter) {
        char charStartLetter = Character.toUpperCase(Startletter);
        return list.stream()
                .filter(l -> !l.isEmpty() && Character.toUpperCase(l.charAt(0)) == charStartLetter)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}