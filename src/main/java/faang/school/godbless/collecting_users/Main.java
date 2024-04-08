package faang.school.godbless.collecting_users;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbies = new HashSet<>(Arrays.asList("Футбол", "Кино", "Чтение"));
        List<User> users = new ArrayList<>();

        users.add(new User(2, "Мария", 30, new HashSet<>(Arrays.asList("Кино", "Театр"))));
        users.add(new User(3, "Петр", 35, new HashSet<>(Arrays.asList("Путешествия", "Фотография"))));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " любит " + entry.getValue());
        }
    }
}
