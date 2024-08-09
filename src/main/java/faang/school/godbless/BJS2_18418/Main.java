package faang.school.godbless.BJS2_18418;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var activities = Set.of("voleyball", "football", "swimming");
        var users = List.of(new User(0, "QWE", 14, Set.of("pc", "coding")),
                            new User(1, "asd", 12, Set.of("dancing", "swimming", "voleyball")),
                            new User(2, "ttt", 23, Set.of("atjumanya", "pres kachat")),
                            new User(3, "gdf", 44, Set.of("begit", "chess", "football")));

        User.findHobbyLovers(users, activities).forEach((key, value) -> System.out.println(key + ", "+ value));
    }
}
