package school.faang;

import school.faang.collection_users.User;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User oneUser = new User(21, "Sergey", 33,
                new HashSet<>(List.of("Чтение", "Бег", "Футбол")));
        User secondUser = new User(1, "Вася", 32,
                new HashSet<>(List.of("Бег", "Баскетбол", "Лыжи")));
        User thirdUser = new User(2, "Коля", 3,
                new HashSet<>(List.of("Курение", "Бег", "Чтение")));

        List<User> users = List.of(oneUser, secondUser, thirdUser);

        Set<String> hobbies = new HashSet<>(List.of("Курение", "Лыжи"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println("Пользователь: " + entry.getKey() + ", Первое Хобби: " + entry.getValue());
        }


    }
}
