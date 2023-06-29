package bc1807;

import LambdaStream.bc1807.Application;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ApplicationTest {

    @Test
    void uniqueNumbers() {
        List<Integer> nums = List.of(1, 2, 3, 5, 7, 10, 12);
        System.out.println(Application.uniqueNumbers(nums, 6));
    }

    @Test
    void countryCapital() {
        Map<String, String> countryCapital = new HashMap<>();
        countryCapital.put("Россия", "Москва");
        countryCapital.put("Германия", "Берлин");
        countryCapital.put("Франция", "Париж");
        countryCapital.put("италия", "Рим");
        countryCapital.put("Япония", "Токио");
        System.out.println(Application.countryCapital(countryCapital));
    }

    @Test
    void filterStrings() {
        List<String> strings = List.of("Petya", "Oleg", "Andrei", "Den", "Alex", "Ali");
        System.out.println(Application.filterStrings(strings, (char) 65));
    }

    @Test
    void pairFriends() {
        Map<String, List<String>> peoples = new HashMap<>();
        peoples.put("Alice", List.of("Bob", "Charlie", "David"));
        peoples.put("Bob", List.of("Alice", "David"));
        peoples.put("Charlie", List.of("Alice", "David"));
        peoples.put("David", List.of("Alice", "Bob", "Charlie", "Eve"));
        peoples.put("Eve", List.of("David"));
        System.out.println(Application.pairFriends(peoples));
    }
}