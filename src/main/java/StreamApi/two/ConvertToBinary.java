package StreamApi.two;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertToBinary {
    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> "Число " + n + " в двоичном формате: " + Integer.toBinaryString(n))
                .collect(Collectors.toList());
    }
}
