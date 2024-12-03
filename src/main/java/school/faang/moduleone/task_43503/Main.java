package school.faang.moduleone.task_43503;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("User1", 20, "Mail.ru", "Moscow"),
                new User("User2", 25, "Mail.ru", "Moscow"),
                new User("User3", 30, "Mail.ru", "Moscow"),
                new User("User4", 40, "Mail.ru", "Moscow"),
                new User("User5", 20, "Mail.ru", "Moscow"),
                new User("User6", 25, "Mail.ru", "Moscow"),
                new User("User7", 30, "Mail.ru", "Moscow"),
                new User("User8", 40, "Mail.ru", "Moscow"),
                new User("User9", 20, "Mail.ru", "Moscow"),
                new User("User10", 25, "Mail.ru", "Moscow")
        );

        System.out.println(User.groupUsers(users));

    }
}
