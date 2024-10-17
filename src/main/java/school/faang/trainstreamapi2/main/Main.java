package school.faang.trainstreamapi2.main;

import school.faang.trainstreamapi2.maincode.StreamApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, String> countries = new HashMap<>();
    public static void main(String[] args) {
        countries.put("Russia", "Moscow");
        countries.put("Portugal", "Lissabon");
        countries.put("Amsterdam", "Amsterdam");

        System.out.println(StreamApi.findPairs(List.of(1 , 2, 3, 4, 5, 6, 7), 7));

        System.out.println(StreamApi.getSortedCapitails(countries));

        System.out.println(StreamApi.sortedAndFilter(List.of("apple", "string", "sonar"), 's'));

        System.out.println(StreamApi.mapDecimalToBinary(List.of(2, 3, 4, 5)));

        System.out.println(StreamApi.filterAndSortByLength(
                List.of("abcdif", "abcdi", "acsd"), "abcdiif"));
    }
}
