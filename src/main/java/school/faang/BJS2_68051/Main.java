package school.faang.BJS2_68051;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> activities = List.of("Swimming", "Fencing", "Modeling");
        List<User> users = List.of(
                new User(1, "Mike", 12, Set.of("Fencing", "Pyromancy", "Black Magic")),
                new User(2, "Alice", 22, Set.of("Sleeping", "Programming", "Gaming")),
                new User(3, "Nick", 33, Set.of("Programming", "Fencing", "Modeling")),
                new User(4, "Mary", 44, Set.of("Swimming", "Reading", "FistFighting")),
                new User(5, "Alex", 55, Set.of("Surgery", "Modeling", "Sleeping")),
                new User(6, "Dummy", 66, Set.of("Surgery", "FistFighting", "Sleeping"))
        );

        // Сделал так, а не просто sout, чтобы вывод был более читабельным
        User.findHobbyLovers(users, activities).entrySet().forEach(System.out::println);
    }
}
