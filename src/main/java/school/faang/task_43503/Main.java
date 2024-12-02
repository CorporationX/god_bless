package school.faang.task_43503;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Ksusha", 20, "java developer", "Minsk"),
                new User("Tatsiana", 22, "c# developer", "Moscow"),
                new User("Ivan", 20, "economist", "Minsk"),
                new User("Kirill", 21, "fullstack developer", "StPetersburg")
        );
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> group : groupedUsers.entrySet()) {
            System.out.println(group.getKey());
            for (User user : group.getValue()) {
                System.out.println(user);
            }
        }
    }
}
