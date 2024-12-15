package school.faang.task_47209;

import java.util.List;
import java.util.stream.Collectors;

public class BinaryConverter {
    public static List<String> convertToBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<String> binaryStrings = convertToBinary(numbers);
        System.out.println(binaryStrings);
    }
}