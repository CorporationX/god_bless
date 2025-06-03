package school.faang.bjs2_79199;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Евгений", 25, new TreeSet<>(Arrays.asList("Футбол", "Шахматы")));
        User user2 = new User(2, "Анна", 30, new TreeSet<>(Arrays.asList("Плавание", "Чтение")));
        User user3 = new User(3, "Иван", 22, new TreeSet<>(Arrays.asList("Шахматы", "Плавание")));

        List<User> users = Arrays.asList(user1, user2, user3);

        Set<String> activities = new HashSet<>(Arrays.asList("Шахматы", "Футбол"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println("Пользователь: " + entry.getKey().getName() +
                    ", Совпадающая активность: " + entry.getValue());
        }
    }
}