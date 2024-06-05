package faang.school.godbless;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Application {
    public static void main(String[] args) {
        User user1 = new User(1, "Боб", 25, new HashSet<>(Arrays.asList("Бег", "Турник")));
        User user2 = new User(2, "Bob", 30, new HashSet<>(Arrays.asList("Бег", "Отжмания")));

        List<User> users = Arrays.asList(user1, user2);

        Set<String> activities = new HashSet<>(Arrays.asList("Бег", "Плаванье"));

        Map<User, String> hobbyLovers = user1.findHobbyLovers(users, activities);

        // Выводим результаты
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getUsername() + " любит " + entry.getValue());
        }

    }
}