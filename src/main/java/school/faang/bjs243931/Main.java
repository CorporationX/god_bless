package school.faang.bjs243931;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> user = new ArrayList<>();
        user.add(new User("Artur", 37, "Google", "San Diego"));
        user.add(new User("Adam", 27, "Amazon", "New York"));
        user.add(new User("Alan", 22, "Google", "Sacramento"));
        user.add(new User("Liuda", 37, "Uber", "San Diego"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(user);

        groupedUsers.forEach((age, userList) -> {
            System.out.println("Возраст: " + age);
            userList.forEach(u -> System.out.println("  " + u));
        });
    }
}