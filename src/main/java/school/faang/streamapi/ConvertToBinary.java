package school.faang.streamapi;

import java.util.*;

public class ConvertToBinary {

    public static List<String> convertToBinary(List<Integer> numbers) {
        List<String> binaryStrings = new ArrayList<>();
        binaryStrings = numbers.stream().map(Integer::toBinaryString).toList();
        return binaryStrings;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<String> result = convertToBinary(numbers);
        System.out.println("Binary conversion: " + result);
    }
}
