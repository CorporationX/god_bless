package faang.school.godbless.core.task_4;

import faang.school.godbless.core.task_4.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static List<User> prepareUsers() {
        User igor = new User(1, "Igor", 18, Set.of("Теннис", "Футбол"));
        User petr = new User(2, "Petr", 23, Set.of("Крикет"));
        User ivan = new User(3, "Ivan", 18, Set.of("Гольф", "Трейдинг", "Вышивание"));
        User olga = new User(4, "Olga", 16, Set.of("Программирование", "Вышивание"));
        User elena = new User(5, "Elena", 18, Collections.emptySet());
        return List.of(igor, petr, ivan, olga, elena);
    }

    public static void main(String[] args) {
        Set<String> hobbies = Set.of("Программирование", "Трейдинг", "Вышивание", "Теннис");
        List<User> users = prepareUsers();
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> hobbyLover : hobbyLovers.entrySet()) {
            System.out.println(hobbyLover.getKey() + " - " + hobbyLover.getValue());
        }
    }
}