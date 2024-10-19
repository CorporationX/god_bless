package school.faang.streamAPI;

import java.util.*;

public class ConvertToBinary {
    public static List<String> convertToBinary(List<Integer> numbers) {
        List<String> binaryStrings = new ArrayList<>();
        for (int number : numbers) {
            binaryStrings.add(Integer.toBinaryString(number));
        }
        return binaryStrings;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<String> result = convertToBinary(numbers);
        System.out.println("Binary conversion: " + result);
    }
}
