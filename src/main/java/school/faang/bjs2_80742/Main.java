package school.faang.bjs2_80742;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info(StreamOperations.findUniquePairsEqualToNumber(Set.of(1, 2, 3, 4, 5), 6).toString());

        List<String> capitals = StreamOperations.printCapitals(Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"));
        log.info(capitals.toString());


        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("ambrosia");
        strings.add("apricot");
        log.info(StreamOperations.sortStringsStartingWithChar(strings, 'a').toString());

        log.info(StreamOperations.convertDecimalToBinary(List.of(1, 2, 3, 4)).toString());

        log.info(StreamOperations.filterByAlphabetAndSortByLength(List.of("apple", "banana", "55tygujk",
                        "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz").toString());

    }
}
