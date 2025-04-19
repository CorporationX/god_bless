package school.faang.map_to_binary_format;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<String> result = mapToBinaryFormat(numbers);
        System.out.println(result);
    }

    private static List<String> mapToBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }
}
