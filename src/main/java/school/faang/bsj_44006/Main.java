package school.faang.bsj_44006;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Сергей", 19, Set.of("путешествия", "футбол", "книги", "хоккей")));
        users.add(new User(2, "Ольга", 24, Set.of("путешествия", "танцы", "книги")));
        users.add(new User(3, "Екатерина", 35, Set.of("футбол", "танцы", "книги")));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, Set.of("путешествия", "сноуборд", "горные лыжи"));
        System.out.println(hobbyLovers);
        System.out.println();

        hobbyLovers = User.findHobbyLovers(users, Set.of("музыка", "сноуборд", "горные лыжи"));
        System.out.println(hobbyLovers);
        System.out.println();

        hobbyLovers = User.findHobbyLovers(users, Set.of("музыка", "хоккей", "горные лыжи"));
        System.out.println(hobbyLovers);
        System.out.println();

    }
}
