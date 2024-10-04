package school.faang.collectingusers;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> setForUser = Set.of("Гольф", "Футбол", "Регби");
        Set<String> setForMethod = Set.of("Хоккей", "Регби", "Теннис");
        Set<String> setNotRepeat = Set.of("Плавание", "Капуера", "Карате");

        List<User> userList = List.of(
                new User(1, "Den", 12, setNotRepeat),
                new User(2, "Masha", 18, setForUser),
                new User(3, "Kate", 17, setNotRepeat)
        );

        User user = new User();
        System.out.println(user.findHobbyLovers(userList, setForMethod));
    }
}
