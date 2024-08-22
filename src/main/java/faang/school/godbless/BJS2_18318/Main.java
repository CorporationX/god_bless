package faang.school.godbless.BJS2_18318;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 8, 5, 12, 7);
        Map<String, String> capitals = Map.of(
                "Russia", "Moscow",
                "Poland", "Warsaw",
                "Italy", "Rome",
                "France", "Paris");
        List<Employee> employees = List.of(new Employee("Eric", 1000, "IT"),
                new Employee("Max", 700, "HR"),
                new Employee("Lilit", 450, "IT"),
                new Employee("Park", 1300, "ITSec"),
                new Employee("Alex", 800, "IT"),
                new Employee("Mark", 850, "HR"));

        Map<String, List<String>> people = Map.of(
                "Robert", List.of("Denis", "Sultan", "Evgenii"),
                "Max", List.of("Kent", "Klark", "Denis"),
                "Sasha", List.of("Pupa", "Lupa", "Chmonya"),
                "Gosha", List.of("Lupa","Gennadiy", "Piotr"),
                "Alex", List.of("Denis", "Asad", "asdas")
        );

        System.out.println(Exercises.getSumOfNumbersThatEqualsToSpecific(numbers, 9));
        System.out.println(Exercises.getSortedCapitals(capitals));
        System.out.println(Exercises.getSortedStringStartedWithSpecificSymbol(Arrays.asList("park", "paska", "damn", "pap", "p"), 'p'));
        System.out.println(Exercises.findAvgSalaryByDepartment(employees));
        System.out.println(Exercises.sortBySpecifiedChars(List.of("asd", "123", "gdfe1", "hhff", "dgjbhnv"), "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(Exercises.convertNumbersToCode(List.of(1, 23, 4, 22)));
        System.out.println(Exercises.findPalindromes(1, 50));
        System.out.println(Exercises.findPalindromesFromString("totat"));
        System.out.println(Exercises.getPeopleWhoDontKnowEachOther(people));
    }
}
