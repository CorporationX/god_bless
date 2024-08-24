package faang.school.godbless.StreamAPI2;

import java.util.*;
import java.util.stream.Collectors;

public class IntegerToBinary {
    public static List<String> convertToBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }
}
