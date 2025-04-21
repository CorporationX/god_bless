package school.faang.stream_api_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        System.out.println("findUniquePairs: " + Operation.findUniquePairs(nums, 8));

        Map<String, String> countries = new HashMap<>();
        countries.put("Germany", "Berlin");
        countries.put("Ukraine", "Kiev");
        countries.put("USA", "Washington");
        countries.put("Czech Republic", "Prague");
        countries.put("Kazakhstan", "Astana");

        System.out.println("capitals: " + Operation.getCapitalsFromCountries(countries));

        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "avocado");
        List<String> filteredByChar = Operation.filterStringsByChar(words, 'a');
        System.out.println("Strings starting with 'a': " + filteredByChar);

        List<Integer> numbers = Arrays.asList(3, 7, 10, 15);
        List<String> binaryStrings = Operation.integerListToBinaryFormat(numbers);
        System.out.println("Binary representations: " + binaryStrings);

        List<String> inputs = Arrays.asList("java", "123", "spring", "4docker", "boot", "k8s");
        List<String> filteredSorted = Operation.filterAndSort(inputs, "[a-zA-Z]+");
        System.out.println("Filtered alphabetic strings sorted by length: " + filteredSorted);
    }
}
