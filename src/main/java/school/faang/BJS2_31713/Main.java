package school.faang.BJS2_31713;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Создаем пользователей
        User user1 = new User(1, "Alice", 25, Arrays.asList("reading", "swimming"), "Google", "London");
        User user2 = new User(2, "Bob", 30, Arrays.asList("cycling", "reading"), "Uber", "New York");
        User user3 = new User(3, "Charlie", 20, Arrays.asList("running", "swimming"), "Amazone", "Amsterdam");

        List<User> users = Arrays.asList(user1, user2, user3);


        // Определяем хобби
        Set<String> hobbies = new HashSet<>(Arrays.asList("reading", "swimming"));

        // Находим пользователей с хобби
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        // Выводим пользователей с их хобби
        hobbyLovers.forEach((user, message) -> System.out.println(message));

        // Печатаем информацию о пользователях

        for (User user : users) {
            System.out.println(user);
        }
    }
}
