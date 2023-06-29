package bc1807;

import LambdaStream.bc1807.Application;
import LambdaStream.bc1807.Employee;
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
        countryCapital.put("Russia", "Moscow");
        countryCapital.put("Germany", "Berlin");
        countryCapital.put("France", "Paris");
        countryCapital.put("Italy", "Rome");
        countryCapital.put("Japan", "Tokyo");
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

    @Test
    void filterRegex() {
        List<String> strings = List.of("Petya", "Oleg1", "Andrei", "Den-Ч", "Alex", "Ali5");
        System.out.println(Application.filterRegex(strings));
    }

    @Test
    void integerToString() {
        List<Integer> numbers = List.of(5, 10, 15, 20);
        System.out.println(Application.integerToString(numbers));
    }

    @Test
    void numberPalindrom() {
        System.out.println(Application.numberPalindrom(1, 1000));
    }

    @Test
    void averageSalary() {
        List<Employee> employees = List.of(
                new Employee("John", 3000.0, "IT"),
                new Employee("Jane", 4000.0, "HR"),
                new Employee("Bob", 3500.0, "IT"),
                new Employee("Alice", 5000.0, "HR"),
                new Employee("Mike", 3800.0, "IT")
        );
        Map<String, Double> statistics = Application.averageSalary(employees);
        for (Map.Entry<String, Double> statistic : statistics.entrySet()) {
            System.out.println(statistic.getKey() + " = " + Math.floor(statistic.getValue()));
        }
    }
}