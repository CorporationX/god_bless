package school.faang.task_47312;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CollectionStreamProcessor collectionStreamProcessor = new CollectionStreamProcessor();
        System.out.println(collectionStreamProcessor.getNumberPairs(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)), 7));

        Map<String, String> capitalsAndCountries = new HashMap<>();
        capitalsAndCountries.put("Russia", "Moscow");
        capitalsAndCountries.put("USA", "Washington");
        capitalsAndCountries.put("Germany", "Berlin");
        System.out.println(collectionStreamProcessor.getSortingCapitals(capitalsAndCountries));

        System.out.println(collectionStreamProcessor.getSortingList(new ArrayList<>(List.of("banana", "avocado",
                "apricot", "apple")), 'a'));

        System.out.println(collectionStreamProcessor.convertToBinary(new ArrayList<>(List.of(1, 2, 3, 4))));

        System.out.println(collectionStreamProcessor.getStringFiltering(new ArrayList<>(List.of("apple", "banana",
                "cherry", "date", "fig", "grape"))));
    }

}
