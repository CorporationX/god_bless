package school.faang.stream2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        Map<String, String> countryMap = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        List<String> stringList = List.of("apple", "banana", "avocado", "apricot");
        List<Integer> intList = List.of(1, 2, 3, 4);
        List<String> stringList2 = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        Set<Pair> pairs = StreamProcessor.sumPairFromNum(numbers, 6);
        System.out.println(pairs);

        List<String> getCapitals = StreamProcessor.sortByCountryAndGetCapitals(countryMap);
        System.out.println(getCapitals);

        List<String> sortedBySymbol = StreamProcessor.sortByFirstSymbol(stringList, 'a');
        System.out.println(sortedBySymbol);

        List<Integer> binaryFrom = StreamProcessor.numbersByBinary(intList);
        System.out.println(binaryFrom);

        List<String> sortByLettersAndLength = StreamProcessor.sortByAlphabetAndLength(
                stringList2, "abcdefghijklmnopqrstuvwxyz"
        );
        System.out.println(sortByLettersAndLength);
    }

}
