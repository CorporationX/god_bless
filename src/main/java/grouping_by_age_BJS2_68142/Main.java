package grouping_by_age_BJS2_68142;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Alex", 20, "Theatre", "London"),
                new User("Sonya", 29, "Mosque", "Budapest"),
                new User("Margaret", 48, "Hospital", "Los Angeles"),
                new User("Fred", 20, "Shop", "Vienna"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.printf("Возраст: %d\n", entry.getKey());
            for (User user : entry.getValue()) {
                System.out.printf("Имя: %s, Место работы: %s, Адрес: %s\n", user.getName(), user.getWorkplace(), user.getAddress());
            }
        }
    }
}