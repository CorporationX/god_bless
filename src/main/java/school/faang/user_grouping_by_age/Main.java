package school.faang.user_grouping_by_age;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static school.faang.user_grouping_by_age.User.groupUsers;

public class Main {

    private static User createUser(String name, Integer age, String workplace, String address) {
        return new User(name, age, workplace, address);
    }

    // Пользователи с разными возрастами
    static User user1 = createUser("Vasya", 24, "Google", "Vashington");
    static User user2 = createUser("Petya", 20, "Facebook", "Paris");
    static User user3 = createUser("David", 18, "Amazon", "Singapur");
    static User user4 = createUser("Nastya", 22, "Yandex", "Moscow");
    static User user5 = createUser("Kira", 42, "Google", "New-York");
    static User user6 = createUser("Koko", 34, "Netflix", "Praga");

    // Пользователи с одинаковыми возрастами (для проверки группировки)
    static User user7 = createUser("Anna", 24, "Microsoft", "Seattle");
    static User user8 = createUser("Mike", 20, "Twitter", "San Francisco");
    static User user9 = createUser("Lisa", 18, "Apple", "Cupertino");

    // Пользователи с пограничными значениями возрастов
    static User user10 = createUser("Max", 0, "N/A", "Home");
    static User user11 = createUser("Eva", 120, "Retired", "Countryside");

    // Пользователи с null значениями (для проверки обработки исключений)
    static User user12 = createUser("John", null, "IBM", "Boston");
    static User user13 = createUser(null, 25, "Oracle", "Redwood");

    private static List<User> listOfUsers = new ArrayList<>(Arrays.asList(
            user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11
    ));

    private static List<User> listWithNulls = new ArrayList<>(Arrays.asList(
            user1, user2, user12, user13
    ));


    public static void main(String[] args) {

        System.out.println("=== Основная группировка пользователей ===");
        Map<Integer, List<User>> groupedUsers = groupUsers(listOfUsers);
        printGroupedUsers(groupedUsers);

        System.out.println("\n=== Группировка с null значениями ===");
        try {
            Map<Integer, List<User>> groupedWithNulls = groupUsers(listWithNulls);
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
