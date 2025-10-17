package school.faang.bjs2_88033;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(Decision.findNumbersBySum(numbers, 6));
        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("Holland", "Amsterdam");
        countriesAndCapitals.put("The USA", "Washington");
        System.out.println(Decision.sortCapitalsByCountries(countriesAndCapitals));
        List<String> strings = List.of("я", "по", "свету", "немало", "хаживал", "ноль", "нет");
        System.out.println(Decision.sortStringsStartWithSymbol(strings, 'н'));
        System.out.println(Decision.numbersToBinaryFormat(new ArrayList<>(numbers)));
        System.out.println(Decision.selectStringsWithDefiniteLetters(strings, "победят"));
    }
}
