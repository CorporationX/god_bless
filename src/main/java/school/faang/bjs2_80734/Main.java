package school.faang.bjs2_80734;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Все пары людей, которые не являются друзьями, но имеют общих друзей: {}.",
                Util.findPeopleWithCommonFriends(Map.of(
                        "Alice", List.of("Bob", "Charlie"),
                        "Bob", List.of("Alice", "Dave"),
                        "Charlie", List.of("Alice", "David"),
                        "David", List.of("Bob", "Charlie")
                )));

        log.info("Средняя зарплата по каждому отделу: {}.",
                Util.findAverageSalaryByDepartment(List.of(
                        new Employee("Alice", 5500, "IT"),
                        new Employee("Bob", 6300, "Marketing"),
                        new Employee("Charlie", 7200, "IT"),
                        new Employee("David", 8600, "Marketing"),
                        new Employee("Eve", 8900, "IT")
                )));

        log.info("Числа-палиндромы в диапазоне от 100 до 200: {}.",
                Util.findPalindromeNumbers(100, 200));

        log.info("Строки-палиндромы: {}.",
                Util.findPalindromeSubstrings("abac"));

        log.info("Все совершенные числа в заданном диапазоне от 1 до 1000: {}.",
                Util.findPerfectNumbers(1, 1000));
    }
}
