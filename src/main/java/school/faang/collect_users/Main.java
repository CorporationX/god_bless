package school.faang.collect_users;

import java.util.List;

import static school.faang.collect_users.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Вася", 22, List.of("Плавание", "Чтение"));
        User user2 = new User(2, "Петя", 22, List.of("Бокс", "Карате"));
        User user3 = new User(3, "Саша", 22, List.of("Музыка", "Вокал"));
        User user4 = new User(4, "Маша", 22, List.of("Волейбол", "Рисование"));
        User user5 = new User(5, "Соня", 22, List.of("Теннис", "Шахматы"));

        List<User> users = List.of(user, user2, user3, user4, user5);

        System.out.println(findHobbyLovers(List.of("Плавание", "Музыка", "Шахматы"), users));

    }
}
