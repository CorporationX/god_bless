package school.faang.streamapitwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // two sum
        List<Integer> numbers = Arrays.asList(1, 3, 4, 2, 6, 3);
        int target = 6;

        StreamProcessor.twoSum(numbers, target);

        // sort map
        Map<String, String> countries = new HashMap<>();
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        countries.put("Australia", "Canberra");

        System.out.println(StreamProcessor.sortByAlphabet(countries));

        // sort words
        List<String> words = Arrays.asList("avocado", "orange", "apple", "apricot");
        System.out.println(StreamProcessor.sortStrings(words, 'a'));

        // convert int to binary words
        List<Integer> nums = Arrays.asList(1, 2, 3 , 4);
        System.out.println(StreamProcessor.convertToBinaryString(nums));

        // sort by alphabet and length
        List<String> strings = Arrays.asList("avocado", "orange", "apple", "apricot", "banana32");
        System.out.println(StreamProcessor.sortString(strings, "abcdefghijklmnopqrstuvwxyz"));

    }
}
