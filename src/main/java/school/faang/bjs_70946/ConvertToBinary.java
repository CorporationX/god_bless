package school.faang.bjs_70946;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertToBinary {
    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        List<String> binaryStrings = convertToBinary(numbers);
        System.out.println(binaryStrings);
    }
}
