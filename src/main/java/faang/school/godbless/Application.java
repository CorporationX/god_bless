package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Set<String> setActivity = Set.of("Плавание", "Бокс", "Танцы", "Хоббихорсинг");
        List<User> usersAll = new ArrayList<>();
        User user1 = new User(1, "Petr", 27, Set.of("Бег", "Бокс"));
        User user2 = new User(2, "Luda", 45, Set.of("Хоббихорсинг", "Сплетни"));
        User user3 = new User(3, "Ivan", 27, Set.of("Бег", "Танцы"));
        User user4 = new User(4, "Sveta", 27, Set.of("Бег", "Плавание"));
        usersAll.add(user1);
        usersAll.add(user2);
        usersAll.add(user3);
        usersAll.add(user4);
        System.out.println(User.findHobbyLovers(usersAll, setActivity));

    }
}
