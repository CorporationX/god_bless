package school.faang.streamApi_2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        findUniqueNumbers(numbers, 7);
        printSites();
        filterForWord('a');
        binaryValue();
        filterWorldsByAlphabet(alphabet);
    }

    public static void findUniqueNumbers(List<Integer> numbers, int findNumber) {
        Set<String> seens = new HashSet<>();
        numbers.stream().forEach(n -> {
            int cont = findNumber - n;
            String seen = "( " + Math.min(n, cont) + "," + Math.max(n, cont) + " )";
            seens.add(seen);
        });
        System.out.println(seens);
    }

    public static void printSites() {
        Map<String, String> countryAndSites = new HashMap<>();
        List<String> sites = new ArrayList<>();
        countryAndSites.put("Russia", "Moscow");
        countryAndSites.put("USA", "Washington");
        countryAndSites.put("Germany", "Berlin");

        countryAndSites.forEach((k, v) -> sites.add(v));

        System.out.println(sites);
    }

    public static void filterForWord(char word) {
        List<String> words = Arrays.asList("apple", "banana", "avocado", "apricot");
        words.stream().filter(w -> w.charAt(0) == word).sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);
    }

    public static void binaryValue() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        List<String> binaryValues = values.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
        System.out.println(binaryValues);
    }

    public static void filterWorldsByAlphabet(String alphabet) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        List<String> newWorld = new ArrayList<>();

        for (String word : words) {
            for (char letter : alphabet.toCharArray()) {
                if (word.indexOf(letter) >= 0) {
                    newWorld.add(word);
                    break;
                }
            }
        }
        System.out.println(newWorld);
    }
}
