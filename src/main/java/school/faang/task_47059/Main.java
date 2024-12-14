package school.faang.task_47059;

import school.faang.error_handler.ErrorHandler;
import school.faang.error_handler.ExceptionHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ExceptionHandler<Void> errorHandler = e -> {
            throw new RuntimeException(e.getMessage());
        };

        ErrorHandler.withErrorHandling(Main::usingStreamApi, errorHandler);
    }

    public static void usingStreamApi() {
        StreamService streamService = new StreamService();
        System.out.println(streamService.findPairs(Arrays.asList(1, 2, 3, 4, 5, 6), 7));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        System.out.println(streamService.getSortedCapitals(countries));

        List<String> fruitList = Arrays.asList("apple", "banana", "avocado", "apricot");
        System.out.println(streamService.filterAndSort(fruitList, 'a'));

        System.out.println(streamService.convertToBinary(Arrays.asList(1, 2, 3, 4)));

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(streamService.filterAndSortByLength(words, alphabet));
    }
}
