package school.faang.bjs2_79199;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Евгений", 25, new TreeSet<>(Set.of("Футбол", "Шахматы")));
        User user2 = new User(2, "Анна", 30, new TreeSet<>(Set.of("Плавание", "Чтение")));
        User user3 = new User(3, "Иван", 22, new TreeSet<>(Set.of("Шахматы", "Плавание")));

        List<User> users = List.of(user1, user2, user3);

        Set<String> activities = Set.of("Шахматы", "Футбол");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            log.info("Пользователь: {}, совпадающая активность: {}",
                    entry.getKey().getName(), entry.getValue());
        }
    }
}