package src.main.java.faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static src.main.java.faang.school.godbless.User.findHobbyLovers;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        Set<String> activities = new HashSet<>();
        activities.add("Футбол");
        activities.add("Баскетбол");

        User user1 = new User(1, "Иван", (byte) 25, new HashSet<>(Arrays.asList("Футбол", "Теннис")));
        User user2 = new User(2, "Алексей", (byte) 30, new HashSet<>(Arrays.asList("Баскетбол", "Теннис")));
        User user3 = new User(3, "Мария", (byte) 28, new HashSet<>(Arrays.asList("Хоккей", "Баскетбол")));
        User user4 = new User(4, "Анна", (byte) 22, new HashSet<>(Arrays.asList("Футбол", "Волейбол")));
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Map<User, String> hobbyLovers = findHobbyLovers(users, activities);
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            User user = entry.getKey();
            String hobby = entry.getValue();
            System.out.println(user.getName() + " любит " + hobby);
        }
    }
}
