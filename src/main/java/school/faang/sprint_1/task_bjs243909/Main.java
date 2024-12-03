package school.faang.sprint_1.task_bjs243909;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Ivan", 24, "Sber", "Moscow"),
                new User("Petr", 33, "RT", "Kazan"),
                new User("John", 40, "Plunder and Flee Inc.", "New York"),
                new User("Jane", 33, "Google X", "Mountain View"),
                new User("Ashley", 24, "Space X", "Boca Chica")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        groupedUsers.forEach((age, usersList) -> {
            System.out.println(age);
            usersList.forEach(System.out::println);
        });
    }
}
