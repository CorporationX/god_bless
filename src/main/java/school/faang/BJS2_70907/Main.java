package school.faang.BJS2_70907;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        List<Map.Entry<String, String>> suggestedFriendPairs = friendsByPerson.entrySet().stream()
                .flatMap(personEntry -> getSuggestedFriendsForPerson(personEntry.getKey(), personEntry.getValue(),
                        friendsByPerson))
                .distinct()
                .toList();
        System.out.println("task1:");
        suggestedFriendPairs.forEach(System.out::println);
    }

    private static Stream<Map.Entry<String, String>> getSuggestedFriendsForPerson(
            String person, List<String> personFriends, Map<String, List<String>> friendsByPerson) {
        return friendsByPerson.entrySet().stream()
                .filter(potentialFriendEntry ->
                        isNotSelfOrExistingFriend(person, personFriends, potentialFriendEntry.getKey()))
                .filter(potentialFriendEntry -> hasMutualFriend(personFriends, potentialFriendEntry.getValue()))
                .map(potentialFriendEntry -> toNormalizePair(person, potentialFriendEntry.getKey()));
    }

    private static boolean isNotSelfOrExistingFriend(String person, List<String> personFriends,
                                                     String potentialFriend) {
        return !potentialFriend.equals(person) && !personFriends.contains(potentialFriend);
    }

    private static boolean hasMutualFriend(List<String> personFriends, List<String> potentialFriendFriends) {
        return potentialFriendFriends.stream()
                .anyMatch(personFriends::contains);
    }

    private static Map.Entry<String, String> toNormalizePair(String person, String potentialFriend) {
        return person.compareTo(potentialFriend) < 0 ? Map.entry(person, potentialFriend)
                : Map.entry(potentialFriend, person);
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
                                Collectors.mapping(Employee::salary, Collectors.toList()),
                                Main::calcAveragingBigDecimal
                        )));
        System.out.println("task2:");
        avgSalaryByDepartment.entrySet().forEach(System.out::println);
    }

    private static BigDecimal calcAveragingBigDecimal(List<BigDecimal> values) {
        BigDecimal total = values.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total.divide(BigDecimal.valueOf(values.size()), 2, RoundingMode.HALF_UP);
    }
}
