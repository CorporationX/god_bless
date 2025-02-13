package school.faang.sprint.second.streamapisecond;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Operations.unique(Set.of(1, 2, 3, 4, 5, 6), 6);

        Operations.sortMap(Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin"));

        Operations.sortList(List.of("apple", "banana", "avocado", "apricot"), 'a');

        Operations.convertListElementToBinary(List.of(1, 2, 3, 4));

        Operations.filterAndSortList(List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "bcdefghijklmnopqrstuvwxyz");
    }
}
