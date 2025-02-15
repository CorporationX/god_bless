package school.faang.stream2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, -2, 0);
        groupNum(numbers, 4);
        convertToBinary(numbers);

        Map<String, String> countriesCity = Map.of("Russia", "Moscow",
                "USA", "Washington", "Germany", "Berlin");
        capitalCity(countriesCity);

        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date",
                "fig", "grape", "avocado", "apricot");
        filterOfStrings(fruits, 'a');
        checkAndFilter(fruits, "acdefghijklmnopqrstuwxyz");

    }

    public static void groupNum(Set<Integer> numbers, Integer sum) {
        try {
            System.out.println(Arrays.toString(numbers.stream()
                    .filter(num -> numbers.contains(sum - num)
                            && num != sum - num)
                    .map(num -> Set.of(num, sum - num))
                    .distinct().toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void capitalCity(Map<String, String> countriesCity) {
        List<String> countries = countriesCity.keySet().stream().sorted()
                .map(countriesCity::get).toList();
        System.out.println(Arrays.toString(countries.toArray()));
    }

    public static void filterOfStrings(List<String> strings, char startOfWord) {
        List<String> sortedAndFilteredStrings = strings.stream()
                .filter(item -> item.charAt(0) == startOfWord)
                .sorted()
                .toList();
        System.out.println(sortedAndFilteredStrings);
    }

    public static void convertToBinary(Set<Integer> numbers) {
        System.out.println(Arrays.toString(numbers.stream()
                .map(Integer::toBinaryString)
                .toArray()));
    }

    public static void checkAndFilter(List<String> strings, String match) {
        List<String> checkedStrings = strings.stream()
                .filter(item -> item.matches("[" + match + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println(Arrays.toString(checkedStrings.toArray()));
    }

}
