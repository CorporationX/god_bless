package school.faang.javacore.groupingusers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Ваня", 20, "Гугл", "Косой переулок"),
                new User("Игорь", 32, "Эппл", "Косая аллея"),
                new User("Леша", 54, "Амазон", "Литл Уингинг"),
                new User("Петя", 20, "Окна", "Тисовая улица")
        );
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        System.out.println(groupedUsers);
    }
}
