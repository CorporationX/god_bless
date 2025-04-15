package school.faang.sprint_1.group_users_by_age;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Alice", 25, "Developer", "London"));
        users.add(new User("Bob", 32, "Designer", "New York"));
        users.add(new User("Charlie", 30, "Teacher", "Berlin"));
        users.add(new User("Diana", 30, "Doctor", "Tokyo"));
        users.add(new User("Ethan", 30, "Student", "Paris"));

        Map<Integer, List<User>> grouped = User.groupUsers(users);

        grouped.forEach((age, userList) -> {
            System.out.println();
            System.out.println("Возраст: " + age);
            userList.forEach(user ->
                    System.out.printf(" - %s, %s, %s ", user.getName(), user.getWork(), user.getAddress()));
        });
    }
}
