package school.faang.sprint1.task44014collectuser;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activ1 = new HashSet<>(Set.of("Баскетболл", "Воллейбол", "Программирование"));
        Set<String> activ2 = new HashSet<>(Set.of("Курение", "Бухание", "Шныряние"));
        Set<String> activ3 = new HashSet<>();

        Set<String> setActivity = new HashSet<>(Set.of("Курение", "Вязание", "Игры", "Баскетболл"));

        User user1 = new User(1, "Maxim", 22, activ1);
        User user2 = new User(2, "Ivan", 23, activ2);
        User user3 = new User(2, "Ivan", 23, activ3);
        User.users.addAll(Set.of(user1, user2, user3));

        Map<User, String> hobbyLovers = User.findHobbyLovers(User.users, setActivity);
        System.out.println(hobbyLovers.get(user1));
        System.out.println(hobbyLovers.get(user2));
        System.out.println(hobbyLovers.get(user3));

    }
}
