package school.faang.task222;

import school.faang.task222.service.StreamService;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StreamService.getPair(List.of(1, 2, 3, 4, 5, 6), 7)
                .forEach(serviceNumber ->
                        System.out.println(serviceNumber.getFirstNumber() + " "
                                + serviceNumber.getSecondNumber()));

        StreamService.sortCountry(Map.of("Russia", "Moscow",
                        "USA", "Washington",
                        "Germany", "Berlin"))
                .forEach(System.out::println);

        StreamService.sortByLengthAndStartWith(List.of("apple", "banana", "avocado", "apricot"), "a")
                .forEach(System.out::println);

        StreamService.getListOfBytes(List.of(1, 2, 3, 4))
                .forEach(System.out::println);

        StreamService.sortByAlphabetAndMatch(List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz")
                .forEach(System.out::println);
    }

}
