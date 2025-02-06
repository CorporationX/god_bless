package school.faang.spring1.basicjava.collectingusers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbies =Set.of("Чтение", "Футбол", "Шахматы", "Плавание", "Кулинария", "Горные лыжи", "Йога");

        User user1 = new User(1, "Кирилл", 25, Set.of("Чтение", "Шахматы"));
        User user2 = new User(2, "Мария", 30, Set.of("Рисование", "Йога"));
        User user3 = new User(3, "Алексей", 28, Set.of( "Охота", "Рыбалка"));
        User user4 = new User(4, "Ольга", 22, Set.of("Кулинария", "Аэробика", "Плавание"));

        List<User> users = List.of(user1, user2, user3, user4);
        System.out.println(new User().findHobbyLovers(users, hobbies));


    }
}
