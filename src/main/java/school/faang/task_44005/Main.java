package school.faang.task_44005;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("peter", 20, "Amazon", "California 2"),
                new User("jack", 20, "Google", "California 3"),
                new User("susan", 25, "Facebook", "California 1"),
                new User("jennie", 25, "Google", "California 3"),
                new User("tom", 30, "Facebook", "California 1"),
                new User("vlad", 28, "Uber", "Amsterdam")
        );
        System.out.printf("Grouped Users:\n%s\n", User.formatGroupedUsers(User.groupUsers(users)));
    }
}
