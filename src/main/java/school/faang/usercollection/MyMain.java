package school.faang.usercollection;

import java.util.Map;
import java.util.Set;

public class MyMain {
    public static void main(String[] args) {

        User user1 = new User(0, "Alex", 18,
                Set.of("IT", "football", "hockey"));
        User user2 = new User(1, "Vlad", 15,
                Set.of("football", "basketball"));
        User user3 = new User(2, "Zaur", 17,
                Set.of("IT", "Lepka", "book"));

        Set<String> activities = Set.of("hockey", "book");
        Set<User> users = Set.of(user1, user2, user3);

        Map<User, String> commonHobbys = User.findHobbyLovers(users, activities);
        for (Map.Entry<User, String> entry : commonHobbys.entrySet()) {
            System.out.println(String.format("User %s has common hobby %s",
                    entry.getKey().getName(), entry.getValue()));
        }
    }
}
