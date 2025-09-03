package school.faang.bjs2_85502;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> usersList = List.of(
                new User(1, "Илья", 26, Set.of("Аниме", "Дотка", "Зал")),
                new User(2, "Виталя", 23, Set.of("Огород", "ПК")),
                new User(3, "Гриша", 24, Set.of("Турник", "Велик", "Карты")),
                new User(4, "Ксюша", 23, Set.of("Карты", "Деньги", "Стволы")),
                new User(5, "Оля", 16, Set.of("Лыжи", "Аниме", "ПК")),
                new User(6, "Витя", 43, Set.of("Аниме", "Велик", "Зал")),
                new User(7, "Даша", 26, Set.of("Рисование", "Покер", "Искуссвто")),
                new User(8, "Алина", 19, Set.of("Гуляния", "Алкоголь", "Зал"))
        );
        System.out.println(User.findHobbyLovers(usersList, Set.of("Аниме", "Лыжи", "Зал")));
    }
}