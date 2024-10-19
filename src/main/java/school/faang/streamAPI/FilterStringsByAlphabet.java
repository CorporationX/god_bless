package school.faang.streamAPI;

import java.util.*;

public class FilterStringsByAlphabet {
    public static List<String> filterStringsByAlphabet(List<String> strings, String alphabet) {
        List<String> validStrings = new ArrayList<>();

        for (String str : strings) {
            boolean isValid = true;
            for (char c : str.toCharArray()) {
                if (alphabet.indexOf(c) == -1) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                validStrings.add(str);
            }
        }

        validStrings.sort(Comparator.comparingInt(String::length));
        return validStrings;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> result = filterStringsByAlphabet(strings, alphabet);
        System.out.println("Filtered and sorted alphabet strings: " + result);
    }
}
