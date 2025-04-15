package school.faang.second_stream;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info(StreamUtil.uniqueSumFinder(Set.of(1, 2, 3, 4, 5), 6).toString());
        log.info(StreamUtil.sortCapitals(Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"))
                .toString());
        log.info(StreamUtil.sortWordsStartsWith(List.of("apple", "banana", "avocado", "apricots"), "a").toString());
        log.info(StreamUtil.toBinary(List.of(1, 2, 3, 4)).toString());
        log.info(StreamUtil.alphabetMatch(List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz").toString());
    }
}
