package school.faang;

import school.faang.usercollection.User;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(0, "Alex", 18,
                List.of("IT", "football", "hockey"));
        User user2 = new User(1, "Vlad", 15,
                List.of("football", "basketball"));
        User user3 = new User(2, "Zaur", 17,
                List.of("IT", "Lepka", "book"));

        List<String> activities = List.of("hockey", "book");
        List<User> users = List.of(user1, user2, user3);

        Map<User, String> commonHobbys = User.findHobbyLovers(users, activities);
        for (Map.Entry<User, String> entry : commonHobbys.entrySet()) {
            System.out.println("User " + entry.getKey().getName() +
                    " have common hobby: " + entry.getValue());
        }
    }
}
