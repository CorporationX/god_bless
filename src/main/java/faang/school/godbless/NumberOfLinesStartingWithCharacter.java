package faang.school.godbless;

import java.util.List;

public class NumberOfLinesStartingWithCharacter {
    public static Long numberOfLinesStartingWithCharacter(List<String> stringList, char startingChar) {
        return stringList.stream()
                .filter(line -> !line.isEmpty() && line.charAt(0) == startingChar)
                .count();
    }
}