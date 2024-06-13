package faang.school.godbless;

import java.util.List;
import java.util.stream.Collectors;

public class StartsWithLetter {
    public static void main(String[] args) {
        List<String> lines = List.of("Sugar", "blow", "start", "summa", "tank", "cat");
        System.out.println(startsWithCharacter(lines, 's'));
    }
    public static List<String> startsWithCharacter(List<String> lines, char letter) {
        return lines.stream()
                .filter((line) -> line.toLowerCase().startsWith(String.valueOf(letter)))
                .collect(Collectors.toList());
    }

}
