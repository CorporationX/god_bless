package school.faang.sprint_2.streamapi2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Integer target = 10;

        System.out.println(Processor.findPairsEqualTarget(numbers, target));

        Map<String, String> countriesWithCapital = Map.of(
                "Denmark", "Copenhagen",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        System.out.println(Processor.sortCountryByAlphabetAndReturnCapitals(countriesWithCapital));

        List<Integer> numbersToBinary = List.of(1, 2, 5, 10);
        System.out.println(Processor.convertingNumbersToBinaryFormat(numbersToBinary));
    }
}
