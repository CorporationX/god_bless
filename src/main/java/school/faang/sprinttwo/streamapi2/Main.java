package school.faang.sprinttwo.streamapi2;

import java.util.Map;
import java.util.Set;



public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        Map<String, String> cityOfCountrys = Map.ofEntries(
                Map.entry("Russia", "Moscow"),
                Map.entry("USA", "Washington"),
                Map.entry("Germany", "Berlin")
        );

        System.out.printf("Все уникальные пары чисел, сумма которых равна 6: %s%n",
                StreamOperations2.unicPairOfNumbers(numbers, 6));

        System.out.printf("Все уникальные пары чисел, сумма которых равна 6: %s%n",
                StreamOperations2.getCapitalOfCountry(cityOfCountrys));
    }


}
