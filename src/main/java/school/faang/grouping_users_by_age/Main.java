package school.faang.grouping_users_by_age;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.grouping_users_by_age.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> testList = List.of(
                new User("Дмитрий", 35, "Yandex", "Saint-Petersburg"),
                new User("Сергей", 21, "VK", "Moscow"),
                new User("Руслан", 35, "Sber", "Moscow"),
                new User("Антон", 20, "Yandex", "Moscow"),
                new User("Евгений", 21, "Sber", "Saint-Petersburg"),
                new User("Максим", 20, "VK", "Saint-Petersburg"),
                new User("Елена", 40, "Aston", "Kazan"),
                new User("Анатолий", 35, "Aston", "Kazan"));
        Map<Integer, ArrayList<User>> testMap = groupUsers(testList);

        for (var entry : testMap.entrySet()) {
            System.out.println("Age group: " + entry.getKey() +
                    " List of Users: " + entry.getValue());
        }
    }
}
