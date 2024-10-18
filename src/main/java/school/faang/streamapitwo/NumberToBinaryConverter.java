package school.faang.streamapitwo;

import java.util.List;
import java.util.stream.Collectors;

public class NumberToBinaryConverter {

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }
}
