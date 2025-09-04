package school.faang.user_grouping_by_age;

import java.util.List;
import java.util.Map;

import static school.faang.user_grouping_by_age.User.groupUsers;

public class Main {

    private static User createUser(String name, Integer age, String workplace, String address) {
        return new User(name, age, workplace, address);
    }


    private static final List<User> differentAgeUsers = List.of(
            createUser("Vasya", 24, "Google", "Vashington"),
            createUser("Petya", 20, "Facebook", "Paris"),
            createUser("David", 18, "Amazon", "Singapur"),
            createUser("Nastya", 22, "Yandex", "Moscow"),
            createUser("Kira", 42, "Google", "New-York"),
            createUser("Koko", 34, "Netflix", "Praga")
    );

    private static final List<User> sameAgeUsers = List.of(
            createUser("Vasya", 24, "Google", "Vashington"),
            createUser("Anna", 24, "Microsoft", "Seattle"),
            createUser("Petya", 20, "Facebook", "Paris"),
            createUser("David", 18, "Amazon", "Singapur"),
            createUser("Mike", 20, "Twitter", "San Francisco"),
            createUser("Lisa", 18, "Apple", "Cupertino")
    );

    private static final List<User> boundaryAgeUsers = List.of(
            createUser("Max", 0, "N/A", "Home"),
            createUser("Eva", 120, "Retired", "Countryside")
    );

    private static final List<User> nullFieldUsers = List.of(
            createUser("John", null, "IBM", "Boston"),
            createUser(null, 25, "Oracle", "Redwood")
    );

    public static void main(String[] args) {

        System.out.println("=== Основная группировка пользователей ===");
        Map<Integer, List<User>> groupedUsers = groupUsers(differentAgeUsers);
        printGroupedUsers(groupedUsers);

        System.out.println("=== Группировка с одинаковыми возрастами ===");
        Map<Integer, List<User>> groupedSameAgeUsers = groupUsers(sameAgeUsers);
        printGroupedUsers(groupedSameAgeUsers);

        System.out.println("=== Группировка с пограничными возрастами ===");
        Map<Integer, List<User>> groupedBoundaryAgeUsers = groupUsers(boundaryAgeUsers);
        printGroupedUsers(groupedBoundaryAgeUsers);

        System.out.println("\n=== Группировка с null значениями ===");
        try {
            Map<Integer, List<User>> groupedWithNulls = groupUsers(nullFieldUsers);
            printGroupedUsers(groupedWithNulls);
        } catch (Exception e) {
            System.out.println("Ошибка при обработке null значений: " + e.getMessage());
        }
    }

    private static void printGroupedUsers(Map<Integer, List<User>> groupedUsers) {
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Возраст " + entry.getKey() + ":");
            for (User user : entry.getValue()) {
                System.out.println("  - " + user.getName() +
                        " (" + user.getWorkplace() + ", " + user.getAddress() + ")");
            }
            System.out.println();
        }
    }
}
