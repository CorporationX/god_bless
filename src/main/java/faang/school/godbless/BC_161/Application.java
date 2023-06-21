package faang.school.godbless.BC_161;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String... args) {
        Set<String> setActivities = Set.of("str1", "activity88", "activity16");
        List<User> userList = List.of(new User(1, "Adam", 35, Set.of("str1", "str2", "str3")),
                                      new User(2, "Adam2", 35, Set.of("str4", "str5", "str6"))
        );
        System.out.println(User.findHobbyLovers(userList, setActivities));
    }
}
