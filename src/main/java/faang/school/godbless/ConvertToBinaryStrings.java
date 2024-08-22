package faang.school.godbless;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertToBinaryStrings {
    public static List<String> doBinariStrings(List<Integer> integerList) {
        return integerList.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }
}