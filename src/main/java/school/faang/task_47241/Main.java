package school.faang.task_47241;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbersTwo = Arrays.asList(543, 52344, 4324235, 3524, 232);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> stringsTwo = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

        String jsonString =
            "{\"Russia\": \"Moscow\", \"USA\": \"Washington\", \"Germany\": \"Berlin\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, String> countryCapitalMap = objectMapper.readValue(jsonString, HashMap.class);

        System.out.println(SteamApi2Testing.uniquePairsNumbers(numbers, 7));
        System.out.println(SteamApi2Testing.sortedCapitals(countryCapitalMap));
        System.out.println(SteamApi2Testing.filteredWords(strings, "a"));
        System.out.println(SteamApi2Testing.convertNumberBinary(numbersTwo));
        System.out.println(SteamApi2Testing.filterAlphabeticallySortLength(stringsTwo, alphabet));
    }
}
