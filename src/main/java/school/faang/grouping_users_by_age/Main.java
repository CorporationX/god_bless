package school.faang.grouping_users_by_age;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static school.faang.grouping_users_by_age.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User testUser1 = new User("Дмитрий", 35, "Yandex", "Saint-Petersburg");
        User testUser2 = new User("Сергей", 21, "VK", "Moscow");
        User testUser3 = new User("Руслан", 35, "Sber", "Moscow");
        User testUser4 = new User("Антон", 20, "Yandex", "Moscow");
        User testUser5 = new User("Евгений", 21, "Sber", "Saint-Petersburg");
        User testUser6 = new User("Максим", 20, "VK", "Saint-Petersburg");
        User testUser7 = new User("Елена", 40, "Aston", "Kazan");
        User testUser8 = new User("Анатолий", 35, "Aston", "Kazan");

        List<User> testList = List.of(testUser1, testUser2, testUser3, testUser4, testUser5,
                testUser6, testUser7, testUser8);
        Map<Integer, ArrayList<User>> testMap = groupUsers(testList);

        for (var entry : testMap.entrySet()) {
            System.out.println("Age group: " + entry.getKey() +
            " List of Users: " + entry.getValue());
        }
    }
}
