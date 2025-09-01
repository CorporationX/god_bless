package school.faang.task2;

import java.util.*;

import static school.faang.task2.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Егор", 18, new HashSet<>(Arrays.asList("волейбол", "чтение", "гитара")));
        User user2 = new User(2, "Ярослав", 19, new HashSet<>(Arrays.asList("Баскетбол", "Волейбол")));
        User user3 = new User(3, "Антон", 18, new HashSet<>(Arrays.asList("футбол", "программирование")));
        User user4 = new User(4, "Анна", 19, new HashSet<>(Arrays.asList("чтение", "кулинария")));

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        Set<String> hobbies = new HashSet<>(Arrays.asList("чтение", "рисование", "гитара"));

        // Ищем любителей хобби
        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);

        System.out.println("Любители хобби:");
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " - " + entry.getValue());
        }
    }
}
