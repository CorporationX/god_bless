package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");

        User us1 = new User(1, 15, "Nemo", Set.of("Курение", "Алкоголизм"));
        User us2 = new User(2, 25, "Vladislav", Set.of("Программирование", "Отжимания"));
        User us3 = new User(3, 17, "Stepan", Set.of("Работа", "Отжимания"));
        User us4 = new User(4, 25, "Alexandr", Set.of("Работа", "Алкоголизм"));

        List<User> users = new ArrayList<>();
        users.add(us1);
        users.add(us2);
        users.add(us3);
        users.add(us4);

        Set<String> goodHabits = Set.of("Программирование", "Отжимания", "Работа");

        System.out.println(User.findHobbyLovers(users, goodHabits));
    }
}