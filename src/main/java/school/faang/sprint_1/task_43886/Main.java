package school.faang.sprint_1.task_43886;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alice", 25, "Google", "New York");
        User user2 = new User("Bob", 30, "Amazon", "San Francisco");
        User user3 = new User("Charlie", 35, "Microsoft", "Seattle");
        User user4 = new User("Diana", 28, "Tesla", "Austin");
        User user5 = new User("Edward", 28, "Facebook", "Miami");

        List<User> users = List.of(user1, user2, user3, user4, user5);
        var groupedUsers = User.groupUsers(users);

        for (var group : groupedUsers.entrySet()) {
            System.out.println(group.getKey() + " : " + group.getValue());
        }
    }

}
