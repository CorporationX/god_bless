package school.faang.tasks_43918;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = createSampleUsers();

        Map<Integer, List<User>> groupedUsers = User.groupAge(users);

        groupedUsers.forEach((age, userList) -> {
            System.out.println("Возраст: " + age);
            userList.forEach(System.out::println);
        });
    }

    private static List<User> createSampleUsers() {
        return Arrays.asList(
                new User("Bagyshan", 23, "GL - backend", "Kalyk-Akieva"),
                new User("Erik", 23, "GL - backend", "Dordoi-Plaza"),
                new User("Atai", 22, "GL - frontend", "Kant"),
                new User("Meerim", 19, "GL - frontend", "Kok-Jar")
        );
    }
}