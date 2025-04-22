package school.faang.stream_api_2;

import java.util.List;
import java.util.stream.Collectors;

public class BinaryConverter {
    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }
}