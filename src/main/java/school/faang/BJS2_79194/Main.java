package school.faang.BJS2_79194;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<User> userSet = Set.of(
                new User(1, "1", 1, Set.of("1", "2")),
                new User(2, "2", 2, Set.of("2", "3")),
                new User(3, "3", 3, Set.of("3", "4")),
                new User(4, "4", 4, Set.of("4", "5")),
                new User(5, "5", 5, Set.of("5", "6"))
        );

        Set<String> hobbySet = Set.of("1", "5");

        Map<User, String> hobbyLoversMap = new User().findHobbyLovers(userSet, hobbySet);
        System.out.println(hobbyLoversMap);
    }
}