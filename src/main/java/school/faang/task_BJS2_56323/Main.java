package school.faang.task_BJS2_56323;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        //создать список пользователей с их хобби
        List<User> users = List.of(
                new User(1, "Anton", 10, new HashSet<>(List.of("Swimming", "Book reading"))),
                new User(2, "Anna", 20, new HashSet<>(List.of("Running", "Book listening"))),
                new User(2, "Oleg", 30, new HashSet<>(List.of("Fitness", "TV watching")))
        );
        //создать список хобби
        Set<String> hobbies = new HashSet<>(List.of("Swimming", "Running"));
        //создать  hashMap и вызвать его для получения результатов соответствия
        Map<String, String> hobbyLovers = User.findHobbyLovers(users, hobbies);
        //вывести полученную hashMap на экран
        for (Map.Entry<String, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
