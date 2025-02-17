package school.faang.sprint1.group_user_by_age_58470;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("John", 24, "Valve", "1 Street"),
                new User("Mary", 24, "Google", "2 Street"),
                new User("Tony", 35, "Apple", "3 Street"),
                new User("Mark", 28, "Microsoft", "4 Street"),
                new User("Helen", 31, "Amazon", "5 Street")
        );

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.println(String.format("Возврастная категория %d:\n\tСписок пользователей (%s)",
                    entry.getKey(), entry.getValue()));
        }
    }
}
