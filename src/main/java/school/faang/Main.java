package school.faang;

import school.faang.service.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:WhitespaceAfter"})
    public static void main(String[] args) {
        Set<String> hobbies = new HashSet<>();
        hobbies.add("Футбол");
        hobbies.add("Вышивание");

        List<User> users = new ArrayList<>();
        User vasya = new User(0, "Вася", 33, new HashSet<>(Arrays.asList("Футбол", "Рыбалка")));
        User petya = new User(1, "Петя", 28, new HashSet<>(Arrays.asList("Волейбол", "Рыбалка")));
        User irina = new User(2, "Ирина", 25, new HashSet<>(Arrays.asList("Волейбол", "Вышивание")));
        User dima = new User(3, "Дима", 28, new HashSet<>(Arrays.asList("Хоккей", "Программирование")));

        users.add(vasya);
        users.add(petya);
        users.add(irina);
        users.add(dima);
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " любит " + entry.getValue());
        }
    }
}

