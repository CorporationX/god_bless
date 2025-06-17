package school.faang.stream2;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        Map<String, String> countryMap = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        List<String> stringList = List.of("apple", "banana", "avocado", "apricot");
        List<Integer> intList = List.of(1, 2, 3, 4);
        List<String> stringList2 = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        Set<Pair> pairs = StreamProcessor.findUniquePairWithSumIsNum(numbers, 6);
        log.info("Числа, сумма которых равна 6: " + pairs);

        List<String> getCapitals = StreamProcessor.sortByCountryAndGetCapitals(countryMap);
        log.info("Столицы в алфавитном порядке их стран: " + getCapitals);

        List<String> sortedBySymbol = StreamProcessor.sortByFirstSymbol(stringList, 'a');
        log.info("Слова, которые начинаются с символа 'а': " + sortedBySymbol);

        List<Integer> binaryFrom = StreamProcessor.numbersByBinary(intList);
        log.info("Двоичный формат переданных чисел: " + binaryFrom);

        List<String> sortByLettersAndLength = StreamProcessor.sortByAlphabetAndLength(
                stringList2, "abcdefghijklmnopqrstuvwxyz"
        );
        log.info("Слова, в которых содержатся символы 'abcdefghijklmnopqrstuvwxyz': " + sortByLettersAndLength);
    }

}
