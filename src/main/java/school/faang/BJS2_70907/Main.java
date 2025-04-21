package school.faang.BJS2_70907;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        Map<String, List<String>> friendsByPerson = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );

        List<Pair<String>> persons = friendsByPerson.entrySet().stream()
                .flatMap(entry -> friendsByPerson.entrySet().stream()
                        .filter(entryInner -> !entryInner.getKey().equals(entry.getKey())
                                && !entry.getValue().contains(entryInner.getKey()))
                        .map(entryInner -> entryInner.getValue().stream()
                                .filter(friend -> entry.getValue().contains(friend))
                                .map(friend -> new Pair<>(entry.getKey(), entryInner.getKey()))
                                .findFirst()
                                .orElse(null)
                        )
                )
                .filter(Objects::nonNull)
                .distinct()
                .toList();

        List<Pair<String>> suggestedFriendPairs = friendsByPerson.entrySet().stream()
                .flatMap(personEntry -> {
                    String person = personEntry.getKey();
                    List<String> personFriends = personEntry.getValue();
                    return friendsByPerson.entrySet().stream()
                            .filter(otherPersonEntry ->  {
                                String otherPerson = otherPersonEntry.getKey();
                                return !otherPerson.equals(person) && !personFriends.contains(otherPerson);
                            })
                            .map(otherPersonEntry -> {
                                String otherPerson = otherPersonEntry.getKey();
                                List<String> otherPersonFriends = otherPersonEntry.getValue();
                                boolean hasMutualFriend = otherPersonFriends.stream()
                                        .anyMatch(personFriends::contains);
                                return hasMutualFriend ? new Pair<>(person, otherPerson) : null;
                            });
                })
                .filter(Objects::nonNull)
                .distinct()
                .toList();
        System.out.println("task1:");
        suggestedFriendPairs.forEach(System.out::println);
    }

    public static void task2() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", new BigDecimal(5000), Department.IT),
                new Employee("Bob", new BigDecimal(6000), Department.IT),
                new Employee("Charlie", new BigDecimal(7000), Department.IT),

                new Employee("Diana", new BigDecimal(4000), Department.HR),
                new Employee("Eva", new BigDecimal(4500), Department.HR),

                new Employee("Frank", new BigDecimal(8000), Department.ACCOUNTING),
                new Employee("George", new BigDecimal(9000), Department.ACCOUNTING),
                new Employee("Helen", new BigDecimal(10000), Department.ACCOUNTING)
        );

        Map<Department, BigDecimal> avgSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.collectingAndThen(
                                Collectors.averagingDouble(employee -> employee.salary().doubleValue()),
                                value -> new BigDecimal(String.valueOf(value)))));
        System.out.println("task2:");
        avgSalaryByDepartment.entrySet().forEach(System.out::println);
    }
}
