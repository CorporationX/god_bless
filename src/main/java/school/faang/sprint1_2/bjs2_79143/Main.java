package school.faang.sprint1_2.bjs2_79143;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "John 1", 18,
                        Set.of("activity 2", "activity 1")),
                new User(2, "John 2", 21,
                        Set.of("activity 1", "activity 2")),
                new User(3, "John", 35,
                        Set.of("activity 3", "activity 5")),
                new User(4, "John ", 50,
                        Set.of("activity 5", "activity 2")),
                new User(5, "John 5", 16,
                        Set.of("activity 3", "activity 4"))
        );

        Map<User, String> list = User.findHobbyLovers(users, List.of("activity 1", "activity 2"));

        list.forEach((user, activity) -> System.out.println(user + ", favorite hobby: " + activity));
    }
}
