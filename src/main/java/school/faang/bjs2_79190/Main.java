package school.faang.bjs2_79190;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        User anna = new User("Anna", 24, Set.of("Вышивание", "Чтение", "Кулинария"));
        User ivan = new User("Ivan", 26, Set.of("Чтение", "Спорт", "Игры"));

        List<User> users = List.of(anna, ivan);
        Set<String> hobbies = Set.of("Спорт", "Игры", "Чтение");
        Map<User, String> hobbyUsers = anna.findHobbyLovers(users, hobbies);
        log.info("Совпавшие активности {}", hobbyUsers);
    }
}
