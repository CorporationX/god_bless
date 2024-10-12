package StreamAPI2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StreamManager streamManager = new StreamManager();
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 8, 7, 9, 5, 3, 4);
        Map<String, String> countries = Map.of("France", "Paris", "Germany", "Berlin",
                "Japan", "Tokyo", "Canada", "Ottawa", "Australia", "Canberra");
        List<String> stringsList = List.of("apple", "banan", "avocadoo", "apricot");
        String alohabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Unique pairs: " + streamManager.findUniquePairs(nums, 10));
        System.out.println("City :" + streamManager.countrySort(countries));
        System.out.println("Sorted strings :" + streamManager.sortStringForLenth(stringsList, 'a'));
        System.out.println("Convert integer to  binary:" + streamManager.makesBinary(nums));
        System.out.println("Strings consisting of the alphabet sorted by length: " + streamManager.filterByLetterContend(stringsList, alohabet));

    }

}
