package school.faang.sprint_2.task_bjs247247;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Map;

@UtilityClass
public class TestDataGenerator {

    public List<Integer> getForFindUniquePairs() {
        return List.of(1, 2, 3, 4, 5, 6);
    }

    public Map<String, String> getForSortedCapitals() {
        return Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin",
                "Zimbabwe", "Harare"
        );
    }

    public List<String> getForFilterAndSortByLength() {
        return List.of("apple", "banana", "avocado", "apricot");
    }

    public List<Integer> getForToBinaryString() {
        return List.of(1, 2, 3, 4);
    }

    public List<String> getForFilterAlphabetSortByLength() {
        return List.of("apple", "banana", "cherry", "date", "fig", "grape");
    }

}
