package school.faang.bjs2_68182;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> testUsers = List.of(
                new User("John", 25, "Company A", "Moscow"),
                new User("Mary", 30, "Company B", "St. Petersburg"),
                new User("Peter", 25, "Company C", "Kazan"),
                new User("Anna", 35, "Company D", "Ekaterinburg"),
                new User("Sergey", 25, "Company E", "Nizhny Novgorod"),
                new User("Olga", 30, "Company F", "Rostov-on-Don")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(testUsers);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println(entry);
        }
    }
}
