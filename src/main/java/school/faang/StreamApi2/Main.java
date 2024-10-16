package school.faang.StreamApi2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.StreamApi2.Operations.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(findUniquePairs(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)), 7));
        ;
        System.out.println(sortCountries(new HashMap<>(Map.of("Russia", "Moscow", "USA"
                , "Washington", "Germany", "Berlin"))));


        System.out.println
                (filterAndSortStrings(new ArrayList<>(List.of("apple", "banana", "avocado", "apricot")), 'a'));

        System.out.println(numbersToBinary(new ArrayList<>(List.of(1, 2, 3, 4))));

        System.out.println
                (filterAndSortByAlphabet(new ArrayList<>(List.of("apple", "banana", "cherry", "date", "fig", "grape"))
                        , "abcdefghijklmnopqrstuvwxyz"));

    }
}
