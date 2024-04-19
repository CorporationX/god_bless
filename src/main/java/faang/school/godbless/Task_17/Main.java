package faang.school.godbless.Task_17;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(uniquePairs(10, Arrays.asList(1, 9, 3, 6, 4, 5)));

        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("England", "London");

        System.out.println(capitals(countriesAndCapitals));
        System.out.println(stringsByParticularRules(Arrays.asList("First", "Second", "Fly", "Finally"), 'F'));

        Map<String, List<String>> peopleAndFriends = new HashMap<>();
        peopleAndFriends.put("John", Arrays.asList("Jessica", "Mike", "Tony"));
        peopleAndFriends.put("Kevin", Arrays.asList("Jessica", "Carla", "Boris"));
        peopleAndFriends.put("Melissa", Arrays.asList("Dorian", "Jason", "Pamella"));
        peopleAndFriends.put("Harry", Arrays.asList("Mike", "Oscar", "Tony"));

        peopleWithCommonFriends(peopleAndFriends);

        middleSalaryByDeparture(Arrays.asList(
                new Employee("John", 1000, "IT"),
                new Employee("Mike", 2000, "Service"),
                new Employee("Tony", 5000, "IT"),
                new Employee("Melissa", 5000, "Science"),
                new Employee("Oscar", 2000, "IT")
        ));


    }

    static Map<Integer, Integer> uniquePairs(int sum, List<Integer> numbers) {
        Map<Integer, Integer> pairs = new HashMap<>();
        IntStream.range(0, numbers.size()).
                forEach(i -> IntStream.range(0, numbers.size()).
                        filter(j -> i != j && numbers.get(i) + numbers.get(j) == sum).
                        forEach(j -> {
                            if (!pairs.containsValue(numbers.get(i))) {
                                pairs.put(numbers.get(i), numbers.get(j));
                            }
                        }));
        return pairs;
    }

    static List<String> capitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).collect(Collectors.toList());
    }

    static List<String> stringsByParticularRules(List<String> strings, char letter) {
        return strings.stream().filter(s -> s.startsWith(String.valueOf(letter))).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    static void peopleWithCommonFriends(Map<String, List<String>> peopleAndFriends) {
        peopleAndFriends.entrySet().stream().
                filter(entryOne -> peopleAndFriends.entrySet().stream().
                        anyMatch(entryAnother -> {
                                    if (!entryOne.getKey().equals(entryAnother.getKey())) {
                                        return entryOne.getValue().stream().
                                                anyMatch(stringFromEntryOne -> entryAnother.getValue().stream().
                                                        anyMatch(stringFromEntryOne::equals));

                                    } else return false;
                                }
                        )).forEach(entry -> System.out.println(entry.getKey()));

    }

    static void middleSalaryByDeparture(List<Employee> employees) {
        Map<String, Double> middleSalaryByDeparture = new HashMap<>();
        employees.stream().collect(Collectors.groupingBy(Employee::getDeparture)).
                forEach((key, value) -> IntStream.range(0, value.size()).forEach(i -> {
                    if (i != 0) {
                        middleSalaryByDeparture.put(key, (middleSalaryByDeparture.get(key) + (value.get(i).getSalary()) / value.size()));
                    } else {
                        middleSalaryByDeparture.put(key, (value.get(i).getSalary()) / value.size());
                    }
                }));
        System.out.println(middleSalaryByDeparture);
    }

}
